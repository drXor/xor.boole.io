package io.boole.makro
 
import language.experimental.macros
import scala.reflect.macros.blackbox
 
/**
 * Golang iota in scala. Inside each iota {} block,
 * each successive reference to iota will be transformed
 * to a literal Int starting from zero. nested iota blocks
 * have their own counters.
 */
object Iota {
 
  def iota[A](block: => A): A = macro iotaImpl[A]
  def iota: Int = throw new IllegalAccessException("iota outside of iota block")
 
  def iotaImpl[A](c: blackbox.Context)(block: c.Expr[A]): c.Expr[A] = {
 
    import c.universe._
 
    object IotaTransformer extends Transformer {
      var count = 0
 
      override def transform(tree: c.Tree): c.Tree = tree match {
        case t @ q"io.boole.makro.Iota.iota[$_]($_)" =>
          t // ignore nested iota blocks
        case q"io.boole.macros.Iota.iota" =>
          val n = count
          count += 1
          c.typecheck(Literal(Constant(n)))
        case t => super.transform(t)
      }
    }
 
    c.Expr[A](IotaTransformer.transform(block.tree))
  }
}

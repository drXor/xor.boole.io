package io.boole.xor.makro

import language.dynamics
import language.experimental.macros
import scala.reflect.macros.whitebox
 
object Alloc extends Dynamic {
 
  private val Unsafe = {
    val uClass = classOf[sun.misc.Unsafe]
    val ctr = uClass.getDeclaredConstructor()
    ctr.setAccessible(true)
    ctr.newInstance()
  }
 
  def inst(c: Class[_]): AnyRef = Unsafe.allocateInstance(c)
 
  def selectDynamic(s: String): AnyRef = macro allocate
  def applyDynamic(s: String): AnyRef = macro allocate
 
  def allocate(c: whitebox.Context)(s: c.Tree): c.Tree = {
 
    import c.universe._
 
    val name = s match {
      case Literal(Constant(str: String)) => str
      case _ => c.error(c.enclosingPosition, "alloc is only supported for literals"); ???
    }
 
    val theType = c.typecheck(q"a: ${TypeName(name)}").tpe.typeSymbol
 
    q"alloc.inst(classOf[$theType])"
  }
}

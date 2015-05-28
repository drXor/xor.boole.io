package io.boole.xor.makro 
 
import language.dynamics
import language.experimental.{macros => __}
import reflect.macros.{whitebox => wb}
 
object Elvis {
 
  implicit class elvis[B](val default: B) extends AnyVal {
    def ?:[A >: B](x: A): A = if(x == null) default else x
  }
 
  implicit class safeCall[A](val x: A) extends AnyVal {
    def ? : A = macro safeCallImpl[A]
  }
 
  def safeCallImpl[A : c.WeakTypeTag](c: wb.Context): c.Expr[A] = {
    import c.universe._
 
    val q"io.boole.xor.makro.Elvis.safeCall[$tpe]($expr).?" = c.macroApplication
 
    val default =
      c.typecheck(tpe.toString match {
        //case Ident(name) => name.decodedName match {
          case "Byte" => q"0.toByte"
          case "Short" => q"0.toShort"
          case "Int" => q"0"
          case "Long" => q"0L"
          case "Float" => q"0F"
          case "Double" => q"0D"
          case "Char" => q"0.toChar"
          case "Boolean" => q"false"
          case "Unit" => q"()"
          case _ => q"null"
        //}
        //case _ => q"null"
      })

    val q"$pre.$memeber[..$tpes](...$args)" = expr
 
    val varName = TermName(c.freshName())
    val newExpr = q"$varName.$memeber[..$tpes](...$args)"
    c.Expr[A](q"{val $varName = $pre; if($varName == null) $default else $newExpr}")
  }
}

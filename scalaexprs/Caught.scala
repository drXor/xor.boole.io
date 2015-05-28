package io.boole.makro 

import language.experimental.macros
import reflect.macros._
 
object Caught {
 
  implicit class _caught[A](val x: A) extends AnyVal {
 
    def caught: Either[Throwable, A] = macro caughtImplImplicit[A]
  }
 
  def caught[A](x: A): Either[Throwable, A] = macro caughtImpl[A]
 
  private def createBlock[A](c: blackbox.Context)(expr: c.Tree): c.Expr[Either[Throwable, A]] = {
    import c.universe._
    c.Expr[Either[Throwable, A]](
      q"""
      try
        Right($expr)
      catch {
        case _root_.scala.util.control.NonFatal(e) => Left(e)
      }
      """
    )
  }
 
  def caughtImplImplicit[A](c: blackbox.Context): c.Expr[Either[Throwable, A]] = {
    import c.universe.Quasiquote
    val q"Caught._caught[$_]($expr).caught" = c.macroApplication
    createBlock(c)(expr).asInstanceOf[c.Expr[Either[Throwable, A]]]
  }
 
  def caughtImpl[A](c: blackbox.Context)(x: c.Expr[A]): c.Expr[Either[Throwable, A]] =
    createBlock(c)(x.tree).asInstanceOf[c.Expr[Either[Throwable, A]]]
}

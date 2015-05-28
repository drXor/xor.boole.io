import io.boole.xor.makro.Caught._

def foo(): String = 
    throw new Exception("boom!")

val either = foo().caught

/* ... */

// handle the exception later

val string = either match {
    case Right(s) => s
    case Left(e : Exception) => // handle
}
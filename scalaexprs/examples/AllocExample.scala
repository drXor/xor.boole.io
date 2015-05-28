import io.boole.xor.makro.Alloc._

val obj = alloc Object

println(str) // java.lang.Object@hash

val str = alloc String

println(str) // NPE! (str.value: Array[Char] is null)
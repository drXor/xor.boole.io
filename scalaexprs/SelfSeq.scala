import collection.mutable.Seq
 
val arr: Seq[A forSome { type A <: Seq[A] }] = Seq(null)
 
val f = arr.getClass.getDeclaredField("array")
f.setAccessible(true)
f.get(arr).asInstanceOf[Array[Object]](0) = arr
 
arr(0)(0)(0) eq arr

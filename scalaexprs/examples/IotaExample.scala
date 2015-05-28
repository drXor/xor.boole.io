import io.boole.xor.makro.Iota._

iota {
    val arr = List (
        1 << iota,
        1 << iota,
        1 << iota,
        1 << iota
    )
    arr.map(_ << iota)
}

// List(32, 64, 128, 256)
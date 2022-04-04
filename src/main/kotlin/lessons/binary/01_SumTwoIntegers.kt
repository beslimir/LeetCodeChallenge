package lessons.binary

fun main(args: Array<String>) {
    val a = 3
    val b = 5

    println(sumTwoIntegers(a, b))
}

fun sumTwoIntegers(x1: Int, x2: Int): Int {
    var a = x1
    var b = x2

    while (b != 0) {
        val tmp = (a.and(b)).shl(1)
        println(tmp)
        a = a.xor(b)
        println(a)
        b = tmp
        println(b)
    }

    return a
}
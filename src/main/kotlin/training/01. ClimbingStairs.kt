package training

fun main(args: Array<String>) {
    println(climbStairs(4))
}

fun climbStairs(num: Int): Int {
    var one = 1
    var two = 1

    for (i in num - 2 downTo 0) {
        val temp = one
        one += two
        two = temp
    }

    return one
}


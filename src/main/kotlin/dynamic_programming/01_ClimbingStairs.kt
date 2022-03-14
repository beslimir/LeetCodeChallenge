package dynamic_programming

fun main(args: Array<String>) {
    println(climbStairs(7))
}

fun climbStairs(n: Int): Int {
    var one = 1
    var two = 1

    for (i in 1 until n) {
        val temp = one
        one += two
        two = temp
    }

    return one

}
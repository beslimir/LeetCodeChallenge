package dynamic_programming

import kotlin.math.max

fun main(args: Array<String>) {
    println(houseRobber(intArrayOf(5, 1, 2, 4)))
}

fun houseRobber(nums: IntArray): Int {
    var robbery1 = 0
    var robbery2 = 0

    //[robbery1, robbery2, n, n + 1,...]
    for(n in nums) {
        val temp = max(n + robbery1, robbery2)
        robbery1 = robbery2
        robbery2 = temp
    }

    return robbery2
}
package training

import kotlin.math.max

fun main(args: Array<String>) {
    println(houseRobber(intArrayOf(5, 1, 2, 4)))
}

fun houseRobber(nums: IntArray): Int {
    var r1 = 0
    var r2 = 0

    for (n in nums) {
        val temp = max(r1 + n, r2)
        r1 = r2
        r2 = temp
    }

    return r2
}
package training

import kotlin.math.max

fun main(args: Array<String>) {
    val nums = intArrayOf(7, 2, 8, 1, 6, 9)

    println(maxProfit(nums))
}

fun maxProfit(nums: IntArray): Int {
    var l = 0
    var r = 1
    var profit = 0
    var maxProfit = 0

    while (r < nums.size) {
        if (nums[r] < nums[l]) {
            l = r
        } else {
            profit = nums[r] - nums[l]
            maxProfit = max(maxProfit, profit)
        }

        r++
    }

    return maxProfit
}
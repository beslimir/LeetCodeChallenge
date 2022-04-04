package lessons.array

import kotlin.math.max

fun main(args: Array<String>) {
    val nums = intArrayOf(7, 1, 5, 3, 6, 4)

    println(maxProfit(nums))
}

fun maxProfit(nums: IntArray): Int {
    var l = 0
    var r = 1
    var maxP = 0
    var profit = 0

    while (r < nums.size) {
        if (nums[l] < nums[r]) {
            profit = nums[r] - nums[l]
            maxP = max(maxP, profit)
        } else {
            l = r
        }

        r++
    }

    return maxP
}
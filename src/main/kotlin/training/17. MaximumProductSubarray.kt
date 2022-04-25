package training

import java.lang.Integer.max
import java.lang.Integer.min

fun main(args: Array<String>) {
    val nums = intArrayOf(2, 0, 3, -2, -2, 4)

    println(maxSubarrayProduct(nums))
}

fun maxSubarrayProduct(nums: IntArray): Int {
    var max = nums[0]
    var min = nums[0]
    var curr = nums[0]

    for (i in 1 until nums.size) {
        var temp = min
        min = min(nums[i], min(nums[i] * max, nums[i] * min))
        max = max(nums[i], max(nums[i] * max, nums[i] * temp))
        curr = max(curr, max)
    }

    return curr
}
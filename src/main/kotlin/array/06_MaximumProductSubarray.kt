package array

import kotlin.math.max

fun main(args: Array<String>) {
    val nums = intArrayOf(11, 2, -3, -4, 0, 7)

    println(maxSubarrayProduct(nums))
}

fun maxSubarrayProduct(nums: IntArray): Int {
    var max = nums[0]
    var curr = nums[0]

    for (i in 1 until nums.size) {
        curr = max(curr * nums[i], nums[i])
        max = max(curr, max)
    }

    return max
}
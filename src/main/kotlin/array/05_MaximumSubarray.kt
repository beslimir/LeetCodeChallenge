package array

import kotlin.math.max

fun main(args: Array<String>) {
    val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)

    println(maximumSubarray(nums))
}

fun maximumSubarray(nums: IntArray): Int {
    var max = nums[0]
    var curr = nums[0]

    for (i in 1 until nums.size) {
        curr = max(curr + nums[i], nums[i])
        max = max(curr, max)
    }

    return max
}
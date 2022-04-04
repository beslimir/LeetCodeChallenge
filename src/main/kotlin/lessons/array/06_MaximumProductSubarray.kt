package lessons.array

import kotlin.math.max
import kotlin.math.min

fun main(args: Array<String>) {
    val nums = intArrayOf(2,0,3,-2,-2,4)

    println(maxSubarrayProduct(nums))
}

fun maxSubarrayProduct(nums: IntArray): Int {
    var max = nums[0]
    var min = nums[0]
    var curr = nums[0]

    for (i in 1 until nums.size) {
        var temp = min
        min = min(nums[i], min(nums[i] * min, nums[i] * max))
        max = max(nums[i], max(nums[i] * max, nums[i] * temp))
        curr = max(max, curr)
    }

    return curr
}
package training

import java.lang.Integer.max
import java.lang.Integer.min

fun main(args: Array<String>) {
    val nums = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)

    println(containerWithMostWater(nums))
}

fun containerWithMostWater(nums: IntArray): Int {
    var l = 0
    var r = nums.size - 1
    var area = 0
    var result = 0

    while (l < r) {
        area = (r - l) * min(nums[l], nums[r])
        result = max(result, area)

        if (nums[l] < nums[r]) {
            l++
        } else {
            r--
        }
    }

    return result
}
package training

import java.lang.Integer.min

fun main(args: Array<String>) {
    val nums = intArrayOf(7, 8, 4, 5, 6)
    println(minRotatedSortedArray(nums))
}

fun minRotatedSortedArray(nums: IntArray): Int {
    var res = nums[0]
    var l = 0
    var r = nums.size - 1

    while (l <= r) {
        if (nums[l] < nums[r]) {
            res = min(res, nums[l])
            break
        }

        val m = (l + r) / 2
        res = min(res, nums[m])

        if (nums[m] >= nums[r]) {
            l = m + 1
        } else {
            r = m - 1
        }
    }

    return res
}
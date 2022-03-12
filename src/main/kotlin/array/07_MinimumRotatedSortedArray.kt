package array

import java.lang.Integer.min

fun main(args: Array<String>) {
    val nums = intArrayOf(1, 2, 3, 4, 5)
    println(minRotatedSortedArray(nums))
}

fun minRotatedSortedArray(nums: IntArray): Int {
    var l = 0
    var r = nums.size - 1
    var res = nums[0]
    var m: Int

    while (l <= r) {
        if (nums[l] < nums[r]) {
            res = min(res, nums[l])
            break
        }

        m = (l + r) / 2
        res = min(res, nums[m])

        if (nums[m] >= nums[r]) {
            l = m + 1
        } else {
            r = m - 1
        }
    }

    return res
}
package dynamic_programming

import java.lang.Integer.max

fun main(args: Array<String>) {
    println(longestIncreasingSubsequence(intArrayOf(0, 1, 0, 3, 2, 3)))
}

fun longestIncreasingSubsequence(nums: IntArray): Int {
    val lis = IntArray(nums.size){1}

    for (i in (nums.size - 2) downTo 0) {
        for (j in (i + 1) until nums.size) {
            if (nums[i] < nums[j]) {
                lis[i] = max(lis[i], 1 + lis[j])
            }
        }
    }

    return lis.maxOrNull()!!
}
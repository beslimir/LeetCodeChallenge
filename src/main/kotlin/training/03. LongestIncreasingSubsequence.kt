package training

import kotlin.math.max

fun main(args: Array<String>) {
    println(longestIncreasingSubsequence(intArrayOf(0, 1, 0, 3, 2, 3)))
}

fun longestIncreasingSubsequence(nums: IntArray): Int {
    var dp = IntArray(nums.size) {1}

    for (i in nums.size - 2 downTo 0) {
        for (j in (i + 1) until nums.size) {
            if (nums[i] < nums[j]) {
                dp[i] = max(dp[i], 1 + dp[j])
            }
        }
    }

    return dp[0]
}
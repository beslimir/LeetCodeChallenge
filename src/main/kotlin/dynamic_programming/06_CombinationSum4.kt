package dynamic_programming

fun main(args: Array<String>) {
    println(combinationSum(intArrayOf(1, 2), 4))
}

fun combinationSum(nums: IntArray, target: Int): Int {
    val dp = IntArray(target + 1){0}
    dp[0] = 1

    for (total in 1..(target)) {
        dp[total] = 0
        for(n in nums) {
            if (total - n >= 0) {
                dp[total] += dp[total - n]
            } else {
                dp[total] += 0
            }
        }
    }

    return dp[target]
}
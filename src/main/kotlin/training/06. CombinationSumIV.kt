package training

fun main(args: Array<String>) {
    println(combinationSum(intArrayOf(1, 2), 4))
}

fun combinationSum(nums: IntArray, target: Int): Int {
    var dp = IntArray(target + 1){0}
    dp[0] = 1

    for (i in 1..target) {
        for (j in nums) {
            if (i >= j) {
                dp[i] += dp[i - j]
            } else {
                dp[i] += 0
            }
        }
    }

    return dp[target]
}
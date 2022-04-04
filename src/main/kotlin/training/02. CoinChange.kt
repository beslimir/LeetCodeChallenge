package training

import java.lang.Integer.min

fun main(args: Array<String>) {
    println(coinChange(intArrayOf(1, 2, 5), 11))
}

fun coinChange(coins: IntArray, target: Int): Int {
    var dp = IntArray(target + 1) {target + 1}
    dp[0] = 0

    for (i in 1..target) {
        for (j in coins) {
            if (i >= j) {
                dp[i] = min(dp[i], 1 + dp[i - j])
            }
        }
    }

    return if (dp[target] != (target + 1)) {
        dp[target]
    } else {
        -1
    }
}
package dynamic_programming

import java.lang.Integer.min

fun main(args: Array<String>) {
    println(coinChange(intArrayOf(1, 2, 5, 6, 7), 9))
}

fun coinChange(coins: IntArray, amount: Int): Int {
    val dp = IntArray(amount + 1) { amount + 1 }
    dp[0] = 0
    //dp = [0, 10, 10, 10, 10, 10, 10, 10, 10, 10]

    for (i in 1 until (amount + 1)) {
        for (j in coins) {
            if (i - j >= 0) {
                dp[i] = min(dp[i], 1 + dp[i - j])
            }
        }
    }

    return if (dp[amount] != (amount + 1)) {
        dp[amount]
    } else {
        -1
    }
}
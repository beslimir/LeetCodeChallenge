package training

import kotlin.math.max

fun main(args: Array<String>) {
    println(longestCommonSubsequence("atrkt", "att"))
}

fun longestCommonSubsequence(text1: String, text2: String): Int {
    var dp = Array(text1.length + 1) {IntArray(text2.length + 1) {0} }

    for (r in text1.length - 1 downTo 0) {
        for (c in text2.length - 1 downTo 0) {
            if (text1[r] == text2[c]) {
                dp[r][c] = 1 + dp[r + 1][c + 1]
            } else {
                dp[r][c] = max(dp[r + 1][c], dp[r][c + 1])
            }
        }
    }

    return dp[0][0]
}
package lessons.dynamic_programming

import java.lang.Integer.max

fun main(args: Array<String>) {
    println(longestCommonSubsequence("abcde", "ace"))
}

fun longestCommonSubsequence(text1: String, text2: String): Int {
    val dp = Array(text1.length + 1) { IntArray(text2.length + 1) { 0 } }

    for (i in (text1.length - 1) downTo 0) {
        for (j in (text2.length - 1) downTo 0) {
            if (text1[i] == text2[j]) {
                dp[i][j] = 1 + dp[i + 1][j + 1]
            } else {
                dp[i][j] = max(dp[i][j + 1], dp[i + 1][j])
            }
        }
    }

    return dp[0][0]
}
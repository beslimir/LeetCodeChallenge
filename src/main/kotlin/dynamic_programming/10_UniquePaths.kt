package dynamic_programming

fun main(args: Array<String>) {
    println(uniquePaths(3, 7))
}

fun uniquePaths(m: Int, n: Int): Int {
    val dp = Array(m + 1) { IntArray(n + 1) { 0 } }
    dp[m - 1][n - 1] = 1

    for (i in (m - 1) downTo 0) {
        for (j in (n - 1) downTo 0) {
            dp[i][j] = dp[i][j] + dp[i + 1][j] + dp[i][j + 1]
        }
    }

    return dp[0][0]
}
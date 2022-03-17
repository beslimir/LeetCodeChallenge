package dynamic_programming

fun main(args: Array<String>) {
    //prvi primjer je DP; drugi je rekurzija
    println(decodeWays("22617"))
}

fun decodeWays(str: String): Int {
    var dp = IntArray(str.length + 1) { 1 }

    for (i in str.length - 1 downTo 0) {
        if (str[i] == '0') {
            dp[i] = 0
        } else {
            dp[i] = dp[i + 1]
        }

        if (i + 1 < str.length &&
            (str[i] == ('1') || (str[i] == '2' && (str[i + 1] == '0'
                    || (str[i + 1] == '1') || (str[i + 1] == '2')
                    || (str[i + 1] == '3') || (str[i + 1] == '4')
                    || (str[i + 1] == '5') || (str[i + 1] == '6')))
                    )
        ) {
            dp[i] += dp[i + 2]
        }
    }

    return dp[0]
}
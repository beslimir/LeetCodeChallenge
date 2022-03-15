package dynamic_programming

fun main(args: Array<String>) {
    println(wordBreak("applepenapple", arrayOf("apple", "pen")))
}

fun wordBreak(text: String, wordDict: Array<String>): Boolean {
    val dp = BooleanArray(text.length + 1) { false }
    dp[text.length] = true

    for (i in (text.length - 1) downTo 0) {
        for (j in wordDict) {
            if (j.length <= text.length - i) {
                val word = text.substring(i, i + j.length)
                if (word == j) {
                    dp[i] = dp[i + j.length]
                }
            }
        }
    }

    return dp[0]
}



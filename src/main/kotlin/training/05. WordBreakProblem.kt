package training

fun main(args: Array<String>) {
    println(wordBreak("applepenapple", arrayOf("apple", "pen")))
}

fun wordBreak(text: String, wordDict: Array<String>): Boolean {
    var dp = BooleanArray(text.length + 1) {false}
    dp[text.length] = true

    for (i in text.length - 1 downTo 0) {
        for (w in wordDict) {
            if (w.length <= text.length - i) {
                if (text.substring(i, i + w.length) == w) {
                    dp[i] = dp[i + w.length]
                }
            }
        }
    }

    return dp[0]
}
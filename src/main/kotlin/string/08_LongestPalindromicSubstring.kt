package string

fun main(args: Array<String>) {
    val str = "nevenjedebanananananas"

    println(longestPalindromicSubstring(str))
}

fun longestPalindromicSubstring(str: String): String {
    var result = ""
    var resLen = 0
    var l: Int
    var r: Int

    for (i in str.indices) {
        l = i
        r = i
        //odd number
        while (l >= 0 && r < str.length && str[l] == str[r]) {
            if (r - l + 1 > resLen) {
                result = str.substring(l, r + 1)
                resLen = result.length
            }
            l--
            r++
        }


        l = i
        r = i + 1
        //even number
        while (l >= 0 && r < str.length && str[l] == str[r]) {
            if (r - l + 1 > resLen) {
                result = str.substring(l, r + 1)
                resLen = result.length
            }
            l--
            r++
        }

    }

    return result
}
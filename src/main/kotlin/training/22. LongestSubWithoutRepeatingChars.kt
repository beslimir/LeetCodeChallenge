package training

import java.lang.Integer.max

fun main(args: Array<String>) {
    println(longestSubstringWithoutRepeatingChars("pwwkew"))
}

fun longestSubstringWithoutRepeatingChars(str: String): Int {
    var charSet = mutableSetOf<Char>()
    var l = 0
    var res = 0

    for (r in str.indices) {
        while (str[r] in charSet) {
            charSet.remove(str[l])
            l++
        }

        charSet.add(str[r])
        res = max(res, r - l + 1)
    }

    return res
}
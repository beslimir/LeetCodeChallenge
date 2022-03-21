package string

import kotlin.math.max

fun main(args: Array<String>) {
    println(longestRepeatingCharReplacement("ABABBA", 2))
}

fun longestRepeatingCharReplacement(str: String, k: Int): Int {
    var count: HashMap<Char, Int> = HashMap<Char, Int>()
    var res = 0
    var l = 0

    for (r in str.indices) {
        count[str[r]] = if (count[str[r]] == null) {
            1
        } else {
            1 + count[str[r]]!!
        }

        while ((r - l + 1) - (count.maxByOrNull { it.value }?.value ?: 0) > k) {
            count[str[l]] = count[str[l]]!! - 1
            l++
        }

        res = max(res, r - l + 1)
    }

    return res
}
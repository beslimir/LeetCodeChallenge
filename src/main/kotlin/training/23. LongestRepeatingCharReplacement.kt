package training

import kotlin.math.max

fun main(args: Array<String>) {
    println(longestRepeatingCharReplacement("ABABBA", 2))
}

fun longestRepeatingCharReplacement(str: String, k: Int): Int {
    val countMap: HashMap<Char, Int> = HashMap<Char, Int>()
    var res = 0
    var l = 0

    for (r in str.indices) {
        countMap[str[r]] = if (countMap[str[r]] == null) {
            1
        } else {
            1 + countMap[str[r]]!!
        }

        while ((r - l + 1) - (countMap.maxByOrNull { it.value }?.value ?: 0) > k) {
            countMap[str[l]] = countMap[str[l]]!! - 1
            l++
        }

        res = max(res, r - l + 1)
    }

    return res
}
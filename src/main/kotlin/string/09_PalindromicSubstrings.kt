package string

fun main(args: Array<String>) {
    val str = "ana"

    println(palindromicSubstrings(str))
}

fun palindromicSubstrings(str: String): Int {
    var result = 0

    for (i in str.indices) {
        var l = i
        var r = i
        while (l >= 0 && r < str.length && str[l] == str[r]) {
            result++
            l--
            r++
        }

        l = i
        r = i + 1
        while (l >= 0 && r < str.length && str[l] == str[r]) {
            result++
            l--
            r++
        }
    }

    return result
}
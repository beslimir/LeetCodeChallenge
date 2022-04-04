package lessons.string

fun main(args: Array<String>) {
    val str = "A man, a plan, a canal: Panama"

    println(validPalindromeWithChecking(str))
}

fun validPalindrome(str: String): Boolean {
    var l = 0
    var r = str.length - 1

    while (l < r) {
        if (str[l].lowercase() != str[r].lowercase()) {
            return false
        }
        l++
        r--
    }

    return true
}

fun validPalindromeWithChecking(str: String): Boolean {
    var l = 0
    var r = str.length - 1

    while (l < r) {
        while (!isAlphaNum(str[l]) && l < r) {
            l++
        }
        while (!isAlphaNum(str[r]) && l < r) {
            r--
        }
        if (str[l].lowercase() != str[r].lowercase()) {
            return false
        }
        l++
        r--
    }

    return true
}

fun isAlphaNum(c: Char): Boolean {
    return (('A'.code <= c.code && c.code <= 'Z'.code) ||
            ('a'.code <= c.code && c.code <= 'z'.code) ||
            ('0'.code <= c.code && c.code <= '9'.code))
}
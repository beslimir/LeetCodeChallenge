package lessons.string

fun main(args: Array<String>) {
    println(minWindowSize("ADOBECODEBANC", "ABC"))
}

fun minWindowSize(str: String, substr: String): String {
    if (str == "") {
        return ""
    }

    val needMap : HashMap<Char, Int> = HashMap()
    val windowMap : HashMap<Char, Int> = HashMap()

    for(c in substr) {
        needMap[c] = 1 + needMap.getOrDefault(c, 0)
    }

    var have = 0
    val need = needMap.size
    var res = intArrayOf(-1, -1)
    var resLen = 999999
    var l = 0

    for (r in str.indices) {
        val c = str[r]
        windowMap[c] = 1 + windowMap.getOrDefault(c, 0)

        if(c in needMap && windowMap[c] == needMap[c]) {
            have++
        }

        while (have == need) {
            //update the result
            if (r - l + 1 < resLen) {
                res = intArrayOf(l, r)
                resLen = r - l + 1
            }
            //pop from the left of the window
            windowMap[str[l]] = windowMap[str[l]]!! - 1
            if (str[l] in needMap && windowMap[str[l]]!! < needMap[str[l]]!!) {
                have--
            }
            l++
        }
    }

    l = res[0]
    val rPointer = res[1]

    return if (resLen != 999999) {
        str.substring(l, rPointer + 1)
    } else {
        ""
    }
}
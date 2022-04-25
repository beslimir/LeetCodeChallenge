package other

fun main(args: Array<String>) {
    println(romanToInt2("CMLIX"))
}

fun romanToInt(s: String): Int {
    val myMap: HashMap<Char, Int> = HashMap()
    myMap['M'] = 1000
    myMap['D'] = 500
    myMap['C'] = 100
    myMap['L'] = 50
    myMap['X'] = 10
    myMap['V'] = 5
    myMap['I'] = 1

    var res = 0
    var temp = myMap[s[s.length - 1]]!! //the last letter

    for (i in s.length - 1 downTo 0) {
        if (myMap[s[i]]!! < temp) {
            res -= myMap[s[i]]!!
        } else {
            res += myMap[s[i]]!!
        }
        temp = myMap[s[i]]!!
    }

    return res
}

fun romanToInt2(s: String): Int {
    var num = 0
    var res = 0
    var temp = 9999

    for (i in 0 until s.length) {
        when {
            s[i] == 'M' -> num = 1000
            s[i] == 'D' -> num = 500
            s[i] == 'C' -> num = 100
            s[i] == 'L' -> num = 50
            s[i] == 'X' -> num = 10
            s[i] == 'V' -> num = 5
            s[i] == 'I' -> num = 1
        }

        if (temp < num) {
            res -= temp * 2
        }

        res += num
        temp = num
    }

    return res
}
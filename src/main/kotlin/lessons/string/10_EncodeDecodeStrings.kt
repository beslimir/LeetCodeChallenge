package lessons.string

fun main(args: Array<String>) {
    val strings = arrayOf("football", "school", "anime", "manga")

    println(encodeStrings(strings))
    println("-----")
//    decodeStrings(encodeStrings(strings)).forEach { println(it) }
    println(decodeStrings(encodeStrings(strings)).contentToString())

}

fun encodeStrings(array: Array<String>): String {
    var result = ""

    for (i in array.indices) {
        result += "${array[i]}##"
    }

    return result
}

fun decodeStrings(string: String): Array<String> {
    var i = 0
    var result = ""
    var array = mutableListOf<String>()

    while (i < string.length) {
        result += string[i]
        if (string[i] == '#' && string[i - 1] == '#') {
            array.add(result.substring(0, result.length - 2))
            result = ""
        }
        i++
    }

    return array.toTypedArray()
}


package string

fun main(args: Array<String>) {
    var array = groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
    for (i in array) {
        for (j in i) {
            println(j)
        }
        println("----")
    }
}

fun groupAnagrams(array: Array<String>): Array<Array<String>> {
    var hashMap1: HashMap<String, Int> = HashMap()

    for (str in array) {
        var temp = str.toCharArray().apply { sort() }.joinToString("")
        hashMap1[temp] = 1 + hashMap1.getOrDefault(temp, 0)
    }

    var result: Array<Array<String>> = Array(hashMap1.size) { arrayOf() }

    var j = 0
    var k = 0
    for (key in hashMap1.keys) {
        for (i in array.indices) {
            if (key == array[i].toCharArray().apply { sort() }.joinToString("")) {
                result[j] = result[j].plus(array[i])
                k++
            }
        }
        j++
        k = 0
    }

    return result
}
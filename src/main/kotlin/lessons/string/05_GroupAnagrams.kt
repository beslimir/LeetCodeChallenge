package lessons.string

import java.util.*


fun main(args: Array<String>) {
    var array = groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
    for (i in array!!) {
        for (j in i) {
            println(j)
        }
        println("----")
    }
}

//faster version
fun groupAnagrams(strs: Array<String>): List<List<String>>? {
    val myArrayList: MutableList<List<String>> = ArrayList()
    val myMap: MutableMap<String, MutableList<String>> = HashMap()

    for (str in strs) {
        val key = sortString(str)
        if (myMap.containsKey(key)) {
            myMap[key]!!.add(str)
        } else {
            val myList: MutableList<String> = ArrayList()
            myList.add(str)
            myMap[key] = myList
        }
    }
    for ((key, value) in myMap) {
        myArrayList.add(value)
    }
    return myArrayList
}

fun sortString(s1: String): String {
    var str = s1
    val c1 = str.toCharArray()

    Arrays.sort(c1)
    str = String(c1)

    return str
}

fun groupAnagrams2(array: Array<String>): Array<Array<String>> {
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
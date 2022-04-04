package lessons.string

fun main(args: Array<String>) {
    println(validAnagram("marin", "niram"))
}

fun validAnagram(str1: String, str2: String): Boolean {
    var hashMap1: HashMap<Char, Int> = HashMap()
    var hashMap2: HashMap<Char, Int> = HashMap()

    if (str1.length != str2.length) {
        return false
    }

    for (c in str1.indices) {
        hashMap1[str1[c]] = 1 + hashMap1.getOrDefault(str1[c], 0)
        hashMap2[str2[c]] = 1 + hashMap2.getOrDefault(str2[c], 0)
    }

    for (key in hashMap1.keys) {
        if (hashMap1[key] != hashMap2[key]) {
            return false
        }
    }

    return true
}
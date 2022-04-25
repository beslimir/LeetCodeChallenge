package other

fun main(args: Array<String>) {
    println(ransomNote2("aa", "aab"))
}

fun ransomNote(ransomNote: String, magazine: String): Boolean {
    val myMap1 : HashMap<Char, Int> = HashMap()
    val myMap2 : HashMap<Char, Int> = HashMap()

    for (i in 0 until ransomNote.length) {
        if (!myMap1.contains(ransomNote[i])) {
            myMap1[ransomNote[i]] = 1
        } else {
            myMap1[ransomNote[i]] = 1 + myMap1[ransomNote[i]]!!
        }
    }

    for (i in 0 until magazine.length) {
        if (!myMap2.contains(magazine[i])) {
            myMap2[magazine[i]] = 1
        } else {
            myMap2[magazine[i]] = 1 + myMap2[magazine[i]]!!
        }
    }

    for (i in 0 until ransomNote.length) {
        if (!myMap2.containsKey(ransomNote[i])
            || myMap2[ransomNote[i]]!! < myMap1[ransomNote[i]]!!) {
            return false
        }
    }

    return true
}

fun ransomNote2(ransomNote: String, magazine: String): Boolean {
    val myMap : HashMap<Char, Int> = HashMap()
    //aa; aab

    for (i in 0 until magazine.length) {
        if (!myMap.contains(magazine[i])) {
            myMap[magazine[i]] = 1
        } else {
            myMap[magazine[i]] = 1 + myMap[magazine[i]]!!
        }
    }

    for (i in 0 until ransomNote.length) {
        if (myMap.contains(ransomNote[i]) && myMap[ransomNote[i]]!! > 0) {
            myMap[ransomNote[i]] = myMap[ransomNote[i]]!! - 1
        } else {
            return false
        }
    }

    return true
}
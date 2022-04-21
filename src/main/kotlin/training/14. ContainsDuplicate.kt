package training

fun main(args: Array<String>) {
    val nums = intArrayOf(9, 2, 31, 1, 2)

    println(containsDuplicate(nums))
}

fun containsDuplicate(nums: IntArray): Boolean {
    var myMap = HashMap<Int, Int>()

    for (i in nums) {
        if (!myMap.containsKey(i)) {
            myMap[i] = 1
        } else {
            return true
        }
    }

    return false
}
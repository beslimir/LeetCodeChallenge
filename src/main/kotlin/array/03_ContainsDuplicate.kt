package array

fun main(args: Array<String>) {
    val nums = intArrayOf(1, 2, 3, 1)

    println(containsDuplicate(nums))
}

fun containsDuplicate(nums: IntArray): Boolean {
    var myMap : HashMap<Int, Int> = HashMap<Int, Int> ()

    for (i in nums) {
        if (myMap.containsValue(i)) {
            return true
        }

        myMap.put(nums.indexOf(i), i)
    }

    return false
}
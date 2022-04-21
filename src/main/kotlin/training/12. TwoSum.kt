package training

fun main(args: Array<String>) {
    val intArray: IntArray = intArrayOf(1, 7, 11, 15)
    val target = 18

    for (i in twoSum(intArray, target)) {
        println(i)
    }
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val myMap : HashMap<Int, Int> = HashMap<Int, Int> ()

    for (i in nums) {
        if (!myMap.contains(target - i)) {
            myMap[i] = nums.indexOf(i)
        } else {
            val tempArray = IntArray(2)
            tempArray[0] = myMap[target - i]!!
            tempArray[1] = nums.indexOf(i)

            return tempArray
        }
    }

    return nums
}
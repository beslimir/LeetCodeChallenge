package lessons.array

fun main(args: Array<String>) {
    val intArray: IntArray = intArrayOf(3, 3)
    val target = 6

    for (i in twoSum(intArray, target)) {
        println(i)
    }
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val myMap : HashMap<Int, Int> = HashMap()

    for (i in nums.indices) {
        val temp = target - nums[i]

        if (myMap.contains(temp)) {
            val tempArray = IntArray(2)
            tempArray[0] = myMap[temp]!!
            tempArray[1] = i

            return tempArray
        }

        myMap.put(nums[i], i)
    }

    return nums
}


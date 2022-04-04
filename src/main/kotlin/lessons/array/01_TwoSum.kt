package lessons.array

fun main(args: Array<String>) {
    val intArray: IntArray = intArrayOf(2, 7, 11, 15)
    val target = 18

    for (i in twoSum(intArray, target)) {
        println(i)
    }
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    var myMap : HashMap<Int, Int> = HashMap<Int, Int> ()

    for (i in nums) {
        val temp = target - i

        if (myMap.contains(temp)) {
            var tempArray = IntArray(2)

            tempArray[1] = nums.indexOf(i)
            tempArray[0] = myMap[temp]!!

            return tempArray
        }

        myMap.put(i, nums.indexOf(i))
    }

    return nums
}


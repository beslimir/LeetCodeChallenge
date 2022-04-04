package lessons.dynamic_programming

import java.lang.Integer.max

fun main(args: Array<String>) {
   println(houseRobber2(intArrayOf(2, 7, 9, 3, 1)))
}

fun houseRobber2(nums: IntArray): Int {
    if (nums.size == 1) {
        return nums[0]
    }

    val res1 = houseRobber(nums.dropLast(1).toIntArray())
    val res2 = houseRobber(nums.drop(1).toIntArray())

    return max(res1, res2)
}
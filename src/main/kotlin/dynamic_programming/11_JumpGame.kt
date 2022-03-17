package dynamic_programming

fun main(args: Array<String>) {
    println(jumpGame(intArrayOf(3, 2, 1, 0, 4)))
}

fun jumpGame(nums: IntArray): Boolean {
    var goal = nums.size - 1

    for (i in nums.size - 1 downTo 0) {
        if (i + nums[i] >= goal) {
            goal = i
        }

    }

    return goal == 0
}
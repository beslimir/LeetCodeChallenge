package training

fun main(args: Array<String>) {
    val nums = intArrayOf(5, 2, 3, 4)
    for (i in productExceptSelfWithoutDivide(nums)) {
        println(i)
    }
    //1. round: 1, 5, 10, 30 (1, 1*5, 1*5*2, 1*5*2*3)
    //2. round: 24, 60, 40, 30 (30, 10*4, 4*3*5, 4*3*2)
}

fun productExceptSelfWithoutDivide(nums: IntArray): IntArray {
    val res = IntArray(nums.size) {1}
    var prefix = 1
    var postfix = 1

    for (i in nums.indices) {
        res[i] = prefix
        prefix *= nums[i]
    }
    for (i in nums.size - 1 downTo 0) {
        res[i] *= postfix
        postfix *= nums[i]
    }

    return res
}
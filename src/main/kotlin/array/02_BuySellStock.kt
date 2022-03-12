package array

fun main(args: Array<String>) {
    val nums = intArrayOf(7, 1, 5, 3, 6, 4)

    println(maxProfit(nums))
}

fun maxProfit(nums: IntArray): Int {
    var min = Integer.MAX_VALUE
    var max = 0

    for (i in nums) {
        if (i < min) {
            min = i
        }
        if (i > max) {
            max = i
        }
    }

    return max - min
}
package array

fun main(args: Array<String>) {
    val nums = intArrayOf(-1, 1, 0, -3, 3)
    for (i in productExceptSelf(nums)) {
        println(i)
    }
}

fun productExceptSelf(nums: IntArray): IntArray {
    var resultNums = IntArray(nums.size)
    var prod = 1
    var zero = 0

    for (i in nums) {
        if (i != 0) {
            prod *= i
        } else {
            zero++
        }
    }

    for (i in nums.indices) {
        if (zero > 0) {
            if (nums[i] != 0 || zero > 1) {
                resultNums[i] = 0
            } else if (zero == 1) {
                resultNums[i] = prod / 1
            }
        } else {
            resultNums[i] = prod / nums[i]
        }
    }

    return resultNums
}
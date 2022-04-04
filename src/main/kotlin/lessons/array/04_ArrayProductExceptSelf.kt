package lessons.array

fun main(args: Array<String>) {
    val nums = intArrayOf(1, 2, 3, 4)
    for (i in productExceptSelfWithoutDivide(nums)) {
        println(i)
    }
}

fun productExceptSelfWithDivide(nums: IntArray): IntArray {
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

fun productExceptSelfWithoutDivide(nums: IntArray): IntArray {
    var res = IntArray(nums.size) {1}
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
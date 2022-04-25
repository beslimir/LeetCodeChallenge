package training

fun main(args: Array<String>) {
    val nums = intArrayOf(-4, -4, -4, -1, 0, 1, 2, 4, 8)

    println(threeSum(nums))
}

fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()
    val result: MutableList<MutableList<Int>> = ArrayList()

    for(i in 0 until nums.size - 1) {
        var l = i + 1
        var r = nums.size - 1

        while (l < r) {
            when {
                nums[l] + nums[r] + nums[i] == 0 -> {
                    if (!result.contains(listOf(nums[l], nums[i], nums[r]))) {
                        result.add(mutableListOf(nums[l], nums[i], nums[r]))
                    }
                    l++
                }
                nums[l] + nums[i] + nums[r] > 0 -> {
                    r -= 1
                }
                else -> {
                    l += 1
                }
            }
        }
    }

    return result
}
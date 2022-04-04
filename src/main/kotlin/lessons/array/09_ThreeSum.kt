package lessons.array


fun main(args: Array<String>) {
    var nums = intArrayOf(-4, -4, -4, -1, 0, 1, 2, 4, 8)

    println(threeSum(nums))
}

fun threeSum(nums: IntArray): List<List<Int>> {
    var result: MutableList<MutableList<Int>> = ArrayList()
    var l: Int
    var r: Int
    nums.sort()

    for (i in 0 until nums.size - 1) {
        l = i + 1
        r = nums.size - 1
        while (l < r) {
            when {
                nums[l] + nums[i] + nums[r] == 0 -> {
                    if (!result.contains(listOf(nums[l], nums[i], nums[r]))) {
                        result.add(mutableListOf(nums[l], nums[i], nums[r]))
                    }
                    l += 1
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

//    result = result.distinct().toMutableList()
    return result
}


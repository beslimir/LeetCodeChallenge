package lessons.array


fun main(args: Array<String>) {
    var nums = intArrayOf(-4, -4, -4, -1, 0, 1, 2, 4, 8)

    println(threeSum(nums))
}

//improved version
fun threeSum(nums: IntArray): List<List<Int>> {
    val result: MutableList<MutableList<Int>> = ArrayList()
    var l: Int
    var r: Int
    nums.sort()

    for (i in 0 until nums.size - 1) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }

        l = i + 1
        r = nums.size - 1
        while (l < r) {
            val threeSum = nums[l] + nums[i] + nums[r]
            when {
                threeSum > 0 -> {
                    r -= 1
                }
                threeSum < 0 -> {
                    l += 1
                }
                else -> {
                    result.add(mutableListOf(nums[l], nums[i], nums[r]))
                    l++
                    //skip the same result
                    while (nums[l] == nums[l - 1] && l < r) {
                        l++
                    }
                }
            }
        }
    }

    return result
}

fun threeSum2(nums: IntArray): List<List<Int>> {
    val result: MutableList<MutableList<Int>> = ArrayList()
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


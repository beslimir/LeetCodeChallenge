package training

fun main(args: Array<String>) {
    val nums = intArrayOf(4, 1, 2, 3)

    println(searchInRotatedSortedArray(nums, 4))
}

fun searchInRotatedSortedArray(nums: IntArray, target: Int): Int {
    var res = 0
    var l = 0
    var r = nums.size - 1

    while (l <= r) {
        val m = (l + r) / 2
        if (target == nums[m]) {
            return m
        }

        if (nums[m] >= nums[l]) {
            if (target > nums[m] || target < nums[l]) {
                //search right
                l = m + 1
            } else {
                //search left
                r = m - 1
            }
        } else {
            if (target < nums[m] || target > nums[r]) {
                //search left
                r = m - 1
            } else {
                //search right
                l = m + 1
            }
        }
    }

    return -1
}
package array

fun main(args: Array<String>) {
    val nums = intArrayOf(5, 6, 7, 1, 2, 3)

    println(searchInRotatedSortedArray(nums, 7))
}

fun searchInRotatedSortedArray(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.size - 1
    var m: Int

    while(l <= r) {
        m = (l + r) / 2
        if (target == nums[m]) {
            return m
        }

        if (nums[l] <= nums[m]) {
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
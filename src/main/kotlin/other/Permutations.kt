package other

fun main(args: Array<String>) {
    println(permutations(mutableListOf(1, 2, 3)))
}

fun permutations(nums: MutableList<Int>): MutableList<MutableList<Int>> {
    val myList: MutableList<MutableList<Int>> = ArrayList()

    if (nums.size == 1) {
        return mutableListOf(mutableListOf(nums[0]))
    }

    for (i in nums.indices) {
        val n = nums.removeAt(0)
        val perms = permutations(nums)

        for (perm in perms) {
            perm.add(n)
        }
        for (i in 0 until perms.size) {
            if (!myList.contains(perms[i])) {
                myList.add(perms[i])
            }
        }
        nums.add(n)
    }

    return myList
}
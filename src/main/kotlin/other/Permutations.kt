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

//2nd solution
fun permute(nums: IntArray): List<List<Int>> {
    val ans =  MutableList<MutableList<Int>>(0){MutableList(0){0}}
    dfs(ans, nums, 0)
    return ans
}
fun dfs(ans: MutableList<MutableList<Int>>, nums: IntArray, index: Int): Unit{
    if (index == nums.size){
        val ls = MutableList<Int>(0){0}
        for (i in 0 until nums.size){
            ls.add(nums[i])
        }
        ans.add(ls)
        return
    }
    for (i in index until nums.size){
        swap(nums, i, index)
        dfs(ans, nums, index+1)
        swap(nums, i, index)
    }
}
fun swap(nums: IntArray, i: Int, j: Int): Unit{
    val tmp = nums[i]
    nums[i] = nums[j]
    nums[j] = tmp
}
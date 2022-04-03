package matrix

fun main(args: Array<String>) {
    rotateImage(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
    )
}

fun rotateImage(matrix: Array<IntArray>) {
    //print
    println("Before the process")
    for (r in 0 until matrix.size) {
        for (c in 0 until matrix[0].size) {
            print(matrix[r][c])
        }
        println()
    }

    var l = 0
    var r = matrix.size - 1
    var temp: Int

    while (l < r) {
        for (i in 0 until r - l) {
            var top = l
            var bottom = r

            //save the top left
            temp = matrix[top][l + i]
            //move bottom left into top left
            matrix[top][l + i] = matrix[bottom - i][l]
            //move bottom right into bottom left
            matrix[bottom - i][l] = matrix[bottom][r - i]
            //move top right into bottom right
            matrix[bottom][r - i] = matrix[top + i][r]
            //move top left into top right
            matrix[top + i][r] = temp
        }
        l++
        r--
    }

    //print
    println("After the process")
    for (r in 0 until matrix.size) {
        for (c in 0 until matrix[0].size) {
            print(matrix[r][c])
        }
        println()
    }

}
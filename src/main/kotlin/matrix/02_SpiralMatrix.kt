package matrix

fun main(args: Array<String>) {
    spiralMatrix(
        arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1)
        )
    )
}

fun spiralMatrix(matrix: Array<IntArray>) {
    var list = mutableListOf<Int>()
    var left = 0
    var right = matrix[0].size
    var top = 0
    var bottom = matrix.size

    //print
    println("Before the process")
    for (r in 0 until matrix.size) {
        for (c in 0 until matrix[0].size) {
            print(matrix[r][c])
        }
        println()
    }

    while (left < right && top < bottom) {
        //the top row
        for (i in left until right) {
            list.add(matrix[top][i])
        }
        top++
        //right column
        for (i in top until bottom) {
            list.add(matrix[i][right - 1])
        }
        right--
        if (left > right || top > bottom) {
            break
        }
        //bottom row
        for (i in (right - 1) downTo left) {
            list.add(matrix[bottom - 1][i])
        }
        bottom--
        //left column
        for (i in (bottom - 1) downTo top) {
            list.add(matrix[i][left])
        }
        left++
    }

    //print
    println("After the process")
    for (i in 0 until list.size) {
        print(list[i])
    }
}
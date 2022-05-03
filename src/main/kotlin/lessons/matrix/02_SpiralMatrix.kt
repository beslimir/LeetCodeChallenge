package lessons.matrix

fun main(args: Array<String>) {
    spiralMatrix(
        arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1)
        )
    )
}

fun spiralMatrix(matrix: Array<IntArray>): List<Int> {
    val list = mutableListOf<Int>()
    val colNumber = matrix[0].size
    val rowNumber = matrix.size
    var top = 0
    var right = colNumber - 1
    var bottom = rowNumber - 1
    var left = 0
    var r = 0
    var c = -1

    //print
    println("Before the process")
    for (r in 0 until rowNumber) {
        for (c in 0 until colNumber) {
            print(matrix[r][c])
        }
        println()
    }

    //while the list has fewer elements than the matrix
    while (list.size < rowNumber * colNumber) {
        while (r == top && c < right && list.size < rowNumber * colNumber) {
            c++
            list.add(matrix[r][c])
        }
        top++
        while (c == right && r < bottom && list.size < rowNumber * colNumber) {
            r++
            list.add(matrix[r][c])
        }
        right--
        while (r == bottom && c > left && list.size < rowNumber * colNumber) {
            c--
            list.add(matrix[r][c])
        }
        bottom--
        while (c == left && r > top && list.size < rowNumber * colNumber) {
            r--
            list.add(matrix[r][c])
        }
        left++
    }

    //print
    println("After the process")
    for (i in 0 until list.size) {
        print(list[i])
    }

    return list
}

fun spiralMatrix2(matrix: Array<IntArray>) {
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
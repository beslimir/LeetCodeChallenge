package training

fun main(args: Array<String>) {
    spiralMatrix(
        arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(4, 5, 6, 7),
            intArrayOf(7, 8, 9, 10)
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
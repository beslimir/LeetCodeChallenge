package matrix

fun main(args: Array<String>) {
    setMatrixZeroes(
        arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1)
        )
    )
}

fun setMatrixZeroes(matrix: Array<IntArray>) {
    val rows = matrix.size
    val cols = matrix[0].size
    var rowZero = false

    //print
    println("Before the process")
    for (r in 0 until rows) {
        for (c in 0 until cols) {
            print(matrix[r][c])
        }
        println()
    }

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (matrix[r][c] == 0) {
                matrix[0][c] = 0
                if (r > 0) {
                    matrix[r][0] = 0
                } else {
                    rowZero = true
                }
            }
        }
    }

    for (r in 1 until rows) {
        for (c in 1 until cols) {
            if (matrix[0][c] == 0 || matrix[r][0] == 0) {
                matrix[r][c] = 0
            }
        }
    }

    if (matrix[0][0] == 0) {
        for (r in 0 until rows) {
            matrix[r][0] = 0
        }
    }
    if (rowZero) {
        for (c in 0 until cols) {
            matrix[0][c] = 0
        }
    }

    //print
    println("After the process")
    for (r in 0 until rows) {
        for (c in 0 until cols) {
            print(matrix[r][c])
        }
        println()
    }
}
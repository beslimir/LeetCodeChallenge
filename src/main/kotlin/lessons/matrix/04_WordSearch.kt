package lessons.matrix

fun main(args: Array<String>) {
    println(
        wordSearch(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            ),
            "ABCCED"
        )
    )
}

fun wordSearch(matrix: Array<CharArray>, word: String): Boolean {
    //print
    println("The Matrix")
    for (element in matrix) {
        for (c in 0 until matrix[0].size) {
            print(element[c])
        }
        println()
    }

    //the task
    val visited = Array(matrix.size) {
        BooleanArray(
            matrix[0].size
        )
    }
    for (i in matrix.indices) {
        for (j in 0 until matrix[0].size) {
            if (matrix[i][j] == word[0]) {
                val result = find(word, i, j, visited, 0, matrix)
                if (result) {
                    return true
                }
            }
        }
    }

    return false
}

private fun find(
    word: String,
    row: Int,
    col: Int,
    visited: Array<BooleanArray>,
    step: Int,
    matrix: Array<CharArray>
): Boolean {
    if (step == word.length - 1) {
        return true
    }
    visited[row][col] = true
    var result = false

    if (row > 0 && matrix[row - 1][col] == word[step + 1] && !visited[row - 1][col]) {
        result = result || find(word, row - 1, col, visited, step + 1, matrix)
    }
    if (row < matrix.size - 1 && matrix[row + 1][col] == word[step + 1] && !visited[row + 1][col]) {
        result = result || find(word, row + 1, col, visited, step + 1, matrix)
    }
    if (col < matrix[0].size - 1 && matrix[row][col + 1] == word[step + 1] && !visited[row][col + 1]) {
        result = result || find(word, row, col + 1, visited, step + 1, matrix)
    }
    if (col > 0 && matrix[row][col - 1] == word[step + 1] && !visited[row][col - 1]) {
        result = result || find(word, row, col - 1, visited, step + 1, matrix)
    }
    visited[row][col] = false

    return result
}

//solution with backtracking
fun wordSearch2(matrix: Array<CharArray>, word: String): Boolean {
    val rows = matrix.size
    val cols = matrix[0].size
    val path: MutableList<Pair<Int, Int>> = mutableListOf()

    fun dfs(r: Int, c: Int, i: Int): Boolean {
        if (i == word.length) {
            return true
        }
        if (r < 0 || c < 0 || r >= rows || c >= cols || word[i] != matrix[r][c] ||
            path.contains(Pair(r, c))) {
            return false
        }
        path.add(i, Pair(r, c))
        val res = (dfs(r + 1, c, i + 1) ||
                dfs(r - 1, c, i + 1) ||
                dfs(r, c + 1, i + 1) ||
                dfs(r, c - 1, i + 1)
                )
        path.remove(Pair(r, c))

        return res
    }

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (dfs(r, c, 0)) {
                return true
            }
        }
    }

    return false
}
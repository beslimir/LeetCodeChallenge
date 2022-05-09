package training

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
fun main() {
    with(System.`in`.bufferedReader()) {
        val (n, m) = readLine().split(" ").map { it.toInt() }

        val originalMatrix = mutableListOf<MutableList<Int>>().let {
            for (y in 0 until n) {
                it.add(readLine().toList().map { c -> c.digitToInt() }.toMutableList())
            }
            it
        }

        val finalMatrix = mutableListOf<MutableList<Int>>().let {
            for (y in 0 until n) {
                it.add(readLine().toList().map { c -> c.digitToInt() }.toMutableList())
            }
            it
        }

        var count = 0

        for (y in 0..n - 3) {
            for (x in 0..m - 3) {
                if (originalMatrix[y][x] != finalMatrix[y][x]) {
                    switchingMatrix(originalMatrix, y, x)
                    count += 1
                }
            }
        }
        if (isEqualMatrix(originalMatrix, finalMatrix)) {
            print(count)
        } else {
            print("-1")
        }

    }
}

fun switchingMatrix(matrix: List<MutableList<Int>>, y: Int, x: Int) {
    for (a in 0 until 3) {
        for (b in 0 until 3) {
            matrix[y + a][x + b] = (matrix[y + a][x + b] + 1) % 2
        }
    }
}

fun isEqualMatrix(original: List<List<Int>>, final: List<List<Int>>): Boolean {
    for (y in original.indices) {
        for (x in original[y].indices) {
            if (original[y][x] != final[y][x]) {
                return false
            }
        }
    }
    return true
}
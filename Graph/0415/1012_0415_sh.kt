import java.util.*

fun main() {
    with(System.`in`.bufferedReader()) {
        val t = readLine().toInt()

        for (ti in 0 until t) {
            val (m, n, k) = readLine().split(" ").map { it.toInt() }

            val maps = Array(n + 2) { Array(m + 2) { false } }.let { maps ->

                for (i in 0 until k) {
                    val (x, y) = readLine().split(" ").map { it.toInt() }

                    maps[y + 1][x + 1] = true
                }
                maps
            }

            var result = 0

            for (y in 1..n) {
                for (x in 1..m) {
                    if (maps[y][x]) {
                        bfs(maps, y to x)
                        result += 1
                    }
                }
            }

            println(result)
        }
    }
}

fun bfs(maps: Array<Array<Boolean>>, location: Pair<Int, Int>) {
    val queue = LinkedList(listOf(location))

    val moveList = listOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)

    while (queue.isNotEmpty()) {
        val (y, x) = queue.poll()

        for ((my, mx) in moveList) {
            if (maps[y + my][x + mx]) {
                queue.add(y + my to x + mx)
                maps[y + my][x + mx] = false
            }
        }
    }
}
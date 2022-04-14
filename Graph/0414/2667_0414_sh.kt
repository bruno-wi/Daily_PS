import java.util.*

fun main() {
    with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()

        val graph = Array(n + 2) { BooleanArray(n + 2) } // 동서남북 한 칸 씩 만들어 줌

        for (y in 1..n) {
            readLine().forEachIndexed { x, c ->
                graph[y][x + 1] = c == '1'
            }
        }

        val resultList = mutableListOf<Int>()

        for (y in 1..n) {
            for (x in 1..n) {
                if (graph[y][x]) {
                    resultList.add(bfs(graph, Pair(y, x)))
                }
            }
        }

        println(resultList.size)
        println(resultList.sorted().joinToString(separator = "\n"))
    }
}

fun bfs(graph: Array<BooleanArray>, startIndex: Pair<Int, Int>): Int {
    val moveList = listOf(Pair(1, 0), Pair(0, 1), Pair(0, -1), Pair(-1, 0))

    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(startIndex)

    graph[startIndex.first][startIndex.second] = false
    var count = 1

    while (queue.isNotEmpty()) {
        val (y, x) = queue.poll()

        moveList.forEach { (moveY, moveX) ->
            if (graph[y + moveY][x + moveX]) {
                queue.add(Pair(y + moveY, x + moveX))
                graph[y + moveY][x + moveX] = false
                count += 1
            }
        }

    }

    return count
}
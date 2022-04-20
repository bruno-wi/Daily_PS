import java.util.*

fun main() {
    with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()

        val parents = Array<Int?>(n + 1) { null }
        parents[1] = 1
        val treeMap = mutableMapOf<Int, MutableList<Int>>()

        repeat(n - 1) {
            val (a, b) = readLine().split(" ").map { it.toInt() }

            treeMap.getOrPut(a) { mutableListOf() }.add(b)
            treeMap.getOrPut(b) { mutableListOf() }.add(a)
        }

        val queue = LinkedList<Int>()

        for (i in 1..n) {
            queue.add(i)

            while (queue.isNotEmpty()) {
                val node = queue.poll()

                val disconnectedNodes = treeMap[node]?.filter { parents[it] == null }?.onEach {
                    parents[it] = node
                } ?: listOf()
                queue.addAll(disconnectedNodes)

            }
        }

        val sb = StringBuilder()

        for (i in 2..n) {
            val result = if (parents[i] == null) {
                "1\n"
            } else {
                "${parents[i]}\n"
            }
            sb.append(result)
        }

        print(sb)
    }
}
fun main() {
    with(System.`in`.bufferedReader()) {
        val nodeMap = mutableMapOf<Int, MutableSet<Int>>().let { nodeMap ->
            val nodes = readLine().toInt()
            val edges = readLine().toInt()

            for (i in 0 until edges) {
                val (n, cn) = readLine().split(" ").map { it.toInt() }

                if (n !in nodeMap) {
                    nodeMap[n] = mutableSetOf(cn)
                } else {
                    nodeMap[n]!!.add(cn)
                }
                if (cn !in nodeMap) {
                    nodeMap[cn] = mutableSetOf(n)
                } else {
                    nodeMap[cn]!!.add(n)
                }
            }
            nodeMap
        }

        print(bfs(nodeMap))
    }
}

fun bfs(nodeMap: MutableMap<Int, MutableSet<Int>>): Int {
    val queue = mutableListOf(1)
    val visited = mutableSetOf(1)

    var count = -1

    while (queue.isNotEmpty()) {
        val n = queue.removeFirst()

        count += 1

        nodeMap[n]!!.forEach { cn ->
            if (cn !in visited) {
                queue.add(cn)
                visited.add(cn)
            }
        }
    }

    return count
}
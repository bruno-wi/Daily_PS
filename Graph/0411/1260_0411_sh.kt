fun main() {
    with(System.`in`.bufferedReader()) {
        val (n, m, v) = readLine().split(" ").map { it.toInt() }

        // node 관계를 list 로 구현했지만 딕셔너리(map)로 구현 가능함 -> 메모리 절약
        val nodes = List<MutableSet<Int>>(n + 1) { mutableSetOf() }.let { edges ->
            for (i in 0 until m) {
                val (node, counterNode) = readLine().split(" ").map { it.toInt() }
                edges[node].add(counterNode)
                edges[counterNode].add(node)
            }
            edges.map { it.sorted() }
        }

        val visitedNodes = Array(n + 1) { false }

        println(dfs(nodes, visitedNodes.copyOf(), v))
        println(bfs(nodes, visitedNodes, v))
    }
}

fun dfs(nodes: List<List<Int>>, visitedNodes: Array<Boolean>, currentNode: Int): String {
    visitedNodes[currentNode] = true

    var result = currentNode.toString()

    nodes[currentNode].forEach { counterNode ->
        if (!visitedNodes[counterNode]) {
            result += " " + dfs(nodes, visitedNodes, counterNode)
        }
    }

    return result
}

fun bfs(nodes: List<List<Int>>, visitedNodes: Array<Boolean>, v: Int): String {
    val queue = mutableListOf<Int>()

    queue.add(v)
    visitedNodes[v] = true

    var result = ""

    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        result += "$node "

        nodes[node].forEach { counterNode ->
            if (!visitedNodes[counterNode]) {
                visitedNodes[counterNode] = true
                queue.add(counterNode)
            }
        }
    }

    return result
}
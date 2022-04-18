fun main() {
    with(System.`in`.bufferedReader()) {
        val t = readLine().toInt()

        repeat(t) {
            val (n, m) = readLine().split(" ").map { it.toInt() }

            val parents = Array(n + 1) { it }
            val edges = mutableListOf<Pair<Int, Int>>()

            for (i in 0 until m) {
                val (a, b) = readLine().split(" ").map { it.toInt() }
                edges.add(Pair(a, b))
            }

            var result = 0

            for ((a, b) in edges) {
                if (findParent(parents, a) != findParent(parents, b)) {
                    unionParent(parents, a, b)
                    result += 1
                }
            }

            println(result)
        }

    }
}

fun findParent(parents: Array<Int>, x: Int): Int {
    if (parents[x] != x) {
        parents[x] = findParent(parents, parents[x])
    }
    return parents[x]
}

fun unionParent(parents: Array<Int>, a: Int, b: Int) {
    val ap = findParent(parents, a)
    val bp = findParent(parents, b)

    if (ap < bp) {
        parents[bp] = parents[ap]
    } else {
        parents[ap] = parents[bp]
    }
}

/*

DFS 로 풀이

fun main() {
    with(System.`in`.bufferedReader()) {
        val t = readLine().toInt()

        for (ti in 0 until t) {
            val (n, m) = readLine().split(" ").map { it.toInt() }

            val graph = Array(n + 1) { mutableSetOf<Int>() }

            for (i in 0 until m) {
                val (a, b) = readLine().split(" ").map { it.toInt() }
                graph[a].add(b)
                graph[b].add(a)
            }

            println(travel(graph, Array(n + 1) { false }))
        }
    }
}

fun travel(graph: Array<MutableSet<Int>>, visited: Array<Boolean>, start: Int = 1): Int {
    visited[start] = true

    var result = 0

    for (v in graph[start]) {
        if (!visited[v]) {
            result += travel(graph, visited, v) + 1
        }
    }

    return result
}
*/

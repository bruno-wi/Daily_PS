fun main() {
    with(System.`in`.bufferedReader()) {
        val (n, w) = readLine().split(" ").map { it.toInt() }

        val edgeCounts = Array(n + 1) { 0 }

        repeat(n - 1) {
            val (a, b) = readLine().split(" ").map { it.toInt() }
            edgeCounts[a] += 1
            edgeCounts[b] += 1
        }

        var lastNodeCount = edgeCounts.slice(2 .. n).filter { it == 1 }.size

        print(w.toDouble() / lastNodeCount.toDouble())
    }
}
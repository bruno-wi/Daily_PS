import java.util.*

val MAX_VALUE = 150000

fun main() {
    with(System.`in`.bufferedReader()) {
        val (n, k) = readLine().split(" ").map { it.toInt() }

        val streets = Array(MAX_VALUE) { MAX_VALUE }

        bfs(streets, n)

        print(streets[k])
    }
}

fun bfs(streets: Array<Int>, location: Int) {
    streets[location] = 0
    val queue = LinkedList(listOf(location to 0))

    while (queue.isNotEmpty()) {
        val (x, count) = queue.poll()

        if (x - 1 >= 0 && streets[x - 1] > count + 1 ) {
            queue.add(x - 1 to count + 1)
            streets[x - 1] = count + 1
        }
        if (x + 1 < MAX_VALUE && streets[x + 1] > count + 1) {
            queue.add(x + 1 to count + 1)
            streets[x + 1] = count + 1
        }
        if (x * 2 < MAX_VALUE && streets[x * 2] > count + 1) {
            queue.add(x * 2 to count + 1)
            streets[x * 2] = count + 1
        }
    }
}
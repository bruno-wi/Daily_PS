import java.util.*

fun main() {
    with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()

        val heap = PriorityQueue<Int>(Collections.reverseOrder())
        // PriorityQueue<Int> { first, last -> last.compareTo(first)} 와 같음

        val sb = StringBuilder()

        for (i in 0 until n) {
            val number = readLine().toInt()

            if (number == 0) {
                sb.append("${heap.poll() ?: 0}\n")
            } else {
                heap.add(number)
            }
        }

        print(sb)
    }
}

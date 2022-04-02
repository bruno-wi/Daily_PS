import java.util.*
import kotlin.math.abs

fun main() {
    with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()

        val heap = PriorityQueue<Int> { c1, c2 ->
            val compared = abs(c1).compareTo(abs(c2))

            if (compared == 0) {
                c1.compareTo(c2)
            } else {
                compared
            }
        }

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

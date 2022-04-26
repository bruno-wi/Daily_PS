import java.util.*

fun main() {
    with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()

        val resultList = LinkedList<Int>()

        var i = 666

        while (resultList.size < n) {
            if ("666" in i.toString()) {
                resultList.add(i)
            }
            i += 1
        }

        print(resultList.last)
    }
}
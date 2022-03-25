fun main() {
    with(System.`in`.bufferedReader()) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        var queue = (0 until n).toMutableList()
        val indexList = readLine().split(" ").map { it.toInt() - 1 }

        var result = 0

        for (i in indexList) {
            if (queue.first() == i) {
                queue.removeFirst()
                continue
            }

            val (shiftQueue, shiftCount) = calculate(queue, i, true)
            val (unshiftQueue, unshiftCount) = calculate(queue, i, false)

            if (shiftCount < unshiftCount) {
                queue = shiftQueue
                result += shiftCount
            } else {
                queue = unshiftQueue
                result += unshiftCount
            }

            queue.removeFirst()
        }

        print(result)
    }
}

fun calculate(queue: MutableList<Int>, value: Int, isShift: Boolean): Pair<MutableList<Int>, Int> {
    val copyQueue = queue.toMutableList()
    var count = 0

    while (copyQueue.first() != value) {
        if (isShift) {
            copyQueue.add(copyQueue.removeFirst())
        } else {
            copyQueue.add(0, copyQueue.removeLast())
        }
        count += 1
    }

    return Pair(copyQueue, count)

}
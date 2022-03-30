fun main() {
    with(System.`in`.bufferedReader()) {
        val (n, m) = readLine().split(" ").map { it.toInt() }

        val words = mutableSetOf<String>()

        for (i in 0 until n) {
            words.add(readLine())
        }

        var result = 0

        for (i in 0 until m) {
            val word = readLine()

            if (word in words) {
                result += 1
            }
        }

        print(result)
    }
}

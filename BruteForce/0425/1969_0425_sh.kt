fun main() {
    with(System.`in`.bufferedReader()) {
        val (n, m) = readLine().split(" ").map { it.toInt() }

        val DNAs = Array(n) { "" }

        for (i in 0 until n) {
            DNAs[i] = readLine()
        }

        var result = ""
        var count = 0

        for (i in 0 until m) {
            val dnaMap = mutableMapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0)

            DNAs.forEach { DNA ->
                dnaMap[DNA[i]] = dnaMap[DNA[i]]!! + 1
            }

            val maxDna = dnaMap.toList()
                .sortedWith(compareByDescending<Pair<Char, Int>> { it.second }.thenBy { it.first }).first().first

            result += maxDna
            count += dnaMap.values.sum() - dnaMap[maxDna]!!
        }

        println(result)
        println(count)
    }
}

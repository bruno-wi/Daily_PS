fun main() {
    with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val playerMap = mutableMapOf<String, Int>()

        for (i in 0 until n) {
            val player = readLine()
            playerMap[player] = (playerMap[player] ?: 0) + 1
        }

        for (i in 0 until n - 1) {
            val finisher = readLine()
            playerMap[finisher] = playerMap[finisher]!! - 1
        }

        print(playerMap.filter { it.value > 0 }.keys.joinToString())
    }
}

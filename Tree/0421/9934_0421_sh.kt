import kotlin.math.sqrt

/*
* BFS 로 풀었다가 메모리 초과로 실패한 문제
* 왜 안되는지 아직도 이해 불가 ..
* */

fun main() {
    with(System.`in`.bufferedReader()) {
        val k = readLine().toInt()

        val cityNumbers = readLine().split(" ").map { it.toInt() }

        val disposedCities = Array(sqrt(cityNumbers.size.toDouble()).toInt() + 1) { mutableListOf<Int>() }

        setDisposedCities(cityNumbers, disposedCities, 0, cityNumbers.size - 1)

        val sb = StringBuilder()

        for (i in disposedCities.indices) {
            for (k in disposedCities[i].indices) {
                sb.append("${disposedCities[i][k]} ")
            }
            sb.append("\n")
        }

        print(sb)
    }
}

fun setDisposedCities(
    cityNumbers: List<Int>,
    disposedCities: Array<MutableList<Int>>,
    left: Int,
    right: Int,
    depth: Int = 0,
) {
    if (left > right) {
        return
    }

    val mid = (left + right) / 2

    disposedCities[depth].add(cityNumbers[mid])
    setDisposedCities(cityNumbers, disposedCities, left, mid - 1, depth + 1)
    setDisposedCities(cityNumbers, disposedCities, mid + 1, right, depth + 1)
}
import kotlin.math.max

/*
* 약간 완전탐색 + 그리디 가 된 것 같다
* 다른 풀이 방법이 있는지 찾아봐야 할 듯
* */

fun main() {
    with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()

        val ropes = mutableListOf<Int>().also {
            for (i in 0 until n) {
                it.add(readLine().toInt())
            }

            it.sort()
        }

        var result = 0

        while (ropes.isNotEmpty()) {
            result = max(result, ropes.size * ropes.removeFirst())
        }

        print(result)
    }
}

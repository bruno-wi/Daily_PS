import kotlin.math.max

fun main() {
    with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val honeys = readLine().split(" ").map(String::toInt)

        /*
        * type 1
        *   벌이 양쪽에 위치하고 꿀통은 가운데 위치
        * type 2
        *   벌은 하나는 끝에 위치하고 꿀통은 그 반대에 위치 나머지 벌 하나는 1 ~ n-1 에 위치
        * */

        var result = 0

        val honeysLeftSums = honeys.runningReduce { acc, value -> acc + value }
        val honeysRightSums = honeys.reversed().runningReduce { acc, value -> acc + value }

        for (i in 1 until n - 1) {

            // type 1
            result = max(
                result,
                (honeysLeftSums[i] - honeys.first()) + (honeysRightSums[n - 1 - i] - honeys.last())
            )

            // type 2
            result = max(
                result,
                max(
                    (honeysLeftSums.last() - honeys.first() - honeys[i]) + (honeysLeftSums.last() - honeysLeftSums[i]),
                    (honeysRightSums.last() - honeys.last() - honeys[n - 1 - i]) + (honeysRightSums.last() - honeysRightSums[i])
                )
            )
        }

        print(result)
    }
}
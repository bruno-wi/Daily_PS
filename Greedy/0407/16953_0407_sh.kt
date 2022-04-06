fun main() {
    with(System.`in`.bufferedReader()) {
        val (a, b) = readLine().split(" ").map { it.toInt() }

        print(calculate(a, b))
    }
}

// 탑다운 방식으로 구현
fun calculate(a: Int, b: Int): Int {
    var count = 1
    var currentValue = b

    while (true) {
        if (currentValue == a) {
            return count
        } else if (currentValue < a) {
            return -1
        }

        currentValue /= if (currentValue % 10 == 1) {
            10
        } else if (currentValue % 2 == 0) {
            2
        } else {
            return -1
        }

        count += 1
    }
}
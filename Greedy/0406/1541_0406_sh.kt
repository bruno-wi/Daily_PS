fun main() {
    with(System.`in`.bufferedReader()) {
        val formula = readLine()

        val result = formula.indexOf('-').let { minusIndex ->
            if (minusIndex != -1) {
                val leftValue = formula.slice(0 until minusIndex).split('+', '-')
                    .fold(0) { acc, s -> acc + s.toInt() }
                val rightValue =
                    formula.slice(minusIndex + 1 until formula.length).split('+', '-')
                        .fold(0) { acc, s -> acc + s.toInt() }

                leftValue - rightValue
            } else {
                formula.split('+', '-')
                    .fold(0) { acc, s -> acc + s.toInt() }
            }

        }

        print(result)
    }
}
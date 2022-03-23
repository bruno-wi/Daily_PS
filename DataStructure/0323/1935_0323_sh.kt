import java.text.DecimalFormat

fun main() {
    val numberMap = mutableMapOf<Char, Double>()
    val formula = mutableListOf<Char>()

    with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        formula.addAll(readLine().toList())
        var alphabet = 'A'
        for (i in 0 until n) {
            numberMap[alphabet++] = readLine().toDouble()
        }
    }

    val calculationStack = mutableListOf<Double>()

    for (c in formula) {
        if (c in 'A'..'Z') {
            calculationStack.add(numberMap[c]!!)
        } else {
            val last = calculationStack.removeLast().toDouble()
            val first = calculationStack.removeLast().toDouble()

            val result = when (c) {
                '*' -> first * last
                '+' -> first + last
                '-' -> first - last
                '/' -> first / last
                else -> 0.0
            }
            calculationStack.add(result)
        }

    }

    print(DecimalFormat("#.00").format(calculationStack.last()))
}
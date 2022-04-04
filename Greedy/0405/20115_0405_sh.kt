fun main() {
    with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()

        val drinkList = readLine()
            .split(" ")
            .map(String::toInt)
            .sortedDescending()
            .toMutableList()

        var result = drinkList.removeFirst().toDouble()

        for (drink in drinkList) {
            result += (drink / 2.0)
        }

        print(result)
    }
}

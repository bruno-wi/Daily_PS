fun main() {
    val (n, k) = System.`in`.bufferedReader().readLine().split(" ").map { it.toInt() }
    val circleList = (1..n).toMutableList()
    var currentIndex = 0

    val resultList = mutableListOf<Int>()

    while (circleList.size > 0) {
        currentIndex = (currentIndex + k - 1) % circleList.size
        resultList.add(circleList[currentIndex])
        circleList.removeAt(currentIndex)
    }

    print(resultList.joinToString(separator = ", ", prefix = "<", postfix = ">"))
}
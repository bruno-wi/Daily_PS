fun main() {
    with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val bookMap = mutableMapOf<String, Int>()

        for (i in 0 until n) {
            val book = readLine()
            bookMap[book] = (bookMap[book] ?: 0) + 1
        }

        // 정렬을 통하여 O(nlogN) 으로 푸는 방법

        print(
            bookMap.toList()
                .sortedWith(
                    compareByDescending<Pair<String, Int>> { it.second }.thenBy { it.first }
                )
                .first().first
        )


/*
        O(n) 으로 푸는 방법

        var bookName = "{"
        var saleCount = 0

        for ((key, value) in bookMap) {
            if (value > saleCount) {
                saleCount = value
                bookName = key
            } else if (value == saleCount && key < bookName) {
                bookName = key
            }
        }

        print(bookName)
*/

    }
}

fun main() {
    /**
     * 시간초과 때문에 상당히 애를 먹었다
     * mutableList 에서 0번째 인덱스에 추가 할 경우 O(n) 시간복잡도가 걸린다는 걸 알게되었다
     * 따라서 arrayList 로 바꾸고 특정 번 째에 추가를 하기보다 항상 맨 뒤에 추가하도록 변경하고 reversed 로 반대 시켜서 출력하였다
     * 또한 앞쪽에 추가되는 부분은 새로운 arrayList 에 추가 시키고 그대로 반환시키도록 하였다
     */
    with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val skillList = readLine().split(" ").map { it.toInt() }

        var card = 1
        val result = arrayListOf<Int>()
        val frontResult = arrayListOf<Int>()

        for (i in 0 until n) {
            if (skillList[n - 1 - i] == 1) {
                result.add(card)
            } else if (skillList[n - 1 - i] == 2) {
                val last = result.removeLast()
                result.add(card)
                result.add(last)
            } else {
                frontResult.add(card)
            }
            card += 1
        }

        print(result.reversed().plus(frontResult).joinToString(separator = " "))
    }
}

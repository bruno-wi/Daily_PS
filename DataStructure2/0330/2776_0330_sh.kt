fun main() {
    /*
    시간 초과 때문에 상당히 애를 먹었다 그래서 이것 저것 찾아본 결과
    단순히 print() 를 사용해서 출력 할 경우 여러번 출력을 하여 꽤나 많은 시간이 소모되기 때문에
    StringBuilder 에 저장시켜놓고 마지막에 한번만 출력 하는 것이 효율적이라고 한다
    또한 Set 에 있는 값을 찾을 때 O(1) 이 든다고 한다 ...!
    그래서 딕셔너리(map) 으로 구현한 것을 다시 Set 으로 정정하였다
    */
    with(System.`in`.bufferedReader()) {
        val t = readLine().toInt()

        for (a in 0 until t) {
            val n = readLine().toInt()
            val firstNote = readLine().split(" ").toSet()

            val m = readLine().toInt()
            val secondNote = readLine().split(" ")

            val sb = StringBuilder()

            for (number in secondNote) {
                val hasNumber = if (number in firstNote) {
                    1
                } else {
                    0
                }
                sb.append("${hasNumber}\n")
            }
            print(sb)
        }
    }
}

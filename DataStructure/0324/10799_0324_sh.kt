fun main() {
    /***
    입력받은 데이터의 맨 처음 문자는 '(' 이기 때문에 pipeCount 를 하나 증가시켜 놓고 2번 째 부터 반복
    why? 반복문이 돌 때 바로 이전 문자의 비교가 필요하기 때문에
     ***/

    val data = System.`in`.bufferedReader().readLine().toList()
    var pipeCount = 1
    var result = 0

    for (i in 1 until data.size) {
        if (data[i] == '(') {
            pipeCount += 1
        } else {
            pipeCount -= 1
            if (data[i] == ')' && data[i - 1] == '(') {
                result += pipeCount
            } else {
                result += 1
            }
        }
    }

    print(result)
}
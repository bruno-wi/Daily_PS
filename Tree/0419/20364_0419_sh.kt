/*
* 풀기는 쉽게 푼 문제지만
* 같은 루트가 또 나오는 경우에 대한 처리를 안해주어서 실패가 계속 났었다
* ex) 2, 6, 6, 6 이라면 답은 0, 0, 6, 6 이여야 하지만 0, 0, 0, 0 이 나옴..
* */

fun main() {
    with(System.`in`.bufferedReader()) {
        val (n, q) = readLine().split(" ").map { it.toInt() }

        val tree = Array(n + 1) { false }

        for (i in 0 until q) {
            val x = readLine().toInt()
            println(getLandIndex(tree, x))
        }
    }
}

fun getLandIndex(tree: Array<Boolean>, x: Int): Int {
    var land = x
    var findIndex = 0 // 요걸 0으로 대입 안하고 x로 했을 때 문제가 발생

    while (land > 1) {
        if (tree[land]) {
            findIndex = land
        }
        land /= 2
    }

    tree[x] = true

    return findIndex
}
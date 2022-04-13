import java.util.*

/**
 * 시간 초과가 나서 당황했었다...
 * 이유가 Queue 목적으로 사용하는 변수를 ArrayList 를 사용하는 mutableListOf 메서드로 생성하였는데
 * add 를 할 때는 할당된 size 보다 커질 경우 더 큰 size 에 array 를 만들고 값을 복사 붙여넣기 하여 사이즈가 커질 때마다 O(n) 의 시간복잡도가 소요된다
 * 또한 remove 를 할 때는 값을 삭제 후 빈 인덱스로 하나씩 값을 끌어와야 해서(unshift) 똑같이 최악의 경우 O(n) 이 발생한다
 * 따라서 Queue 로 사용하기 가장 적합한 LinkedList 로 변경하였다 (처음이나 마지막에 추가, 삭제는 O(1) 이 걸린다)
 */
fun main() {
    with(System.`in`.bufferedReader()) {
        val (n, m) = readLine().split(" ").map { it.toInt() }

        val maze = Array(n + 2) { Array(m + 2) { 0 } }.let { maze ->
            for (yi in 1..n) {
                readLine().forEachIndexed { xi, c ->
                    maze[yi][xi + 1] = if (c == '1') {
                        Int.MAX_VALUE
                    } else {
                        0
                    }
                }
            }
            maze
        }

        print(bfs(maze, n, m))
    }
}

fun bfs(maze: Array<Array<Int>>, n: Int, m: Int): Int {
    val queue = LinkedList<Triple<Int, Int, Int>>()
    queue.add(Triple(1, 1, 1))

    val moveList = listOf(Pair(1, 0), Pair(0, 1), Pair(0, -1), Pair(-1, 0))

    while (queue.isNotEmpty()) {
        val (y, x, count) = queue.poll()

        moveList.forEach { (moveY, moveX) ->
            val next = maze[y + moveY][x + moveX]
            if (next != 0 && next > count + 1) {
                queue.add(Triple(y + moveY, x + moveX, count + 1))
                maze[y + moveY][x + moveX] = count + 1
            }
        }

    }

    return maze[n][m]
}
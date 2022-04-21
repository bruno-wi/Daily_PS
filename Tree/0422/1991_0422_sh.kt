import java.lang.StringBuilder

fun main() {
    with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()

        val treeMap = mutableMapOf<String, Pair<String?, String?>>()

        for (i in 0 until n) {
            val (node, left, right) = readLine().split(" ").map {
                if (it == ".") {
                    null
                } else {
                    it
                }
            }
            treeMap[node!!] = left to right
        }

        val sb = StringBuilder()

        preorderTraversal(treeMap, "A", sb)
        sb.append("\n")

        inorderTraversal(treeMap, "A", sb)
        sb.append("\n")

        postorderTraversal(treeMap, "A", sb)
        sb.append("\n")

        print(sb)
    }
}

fun preorderTraversal(
    treeMap: Map<String, Pair<String?, String?>>,
    start: String,
    sb: StringBuilder
) {
    val (left, right) = treeMap[start] ?: null to null

    sb.append(start)
    if (left != null) {
        preorderTraversal(treeMap, left, sb)
    }
    if (right != null) {
        preorderTraversal(treeMap, right, sb)
    }
}

fun inorderTraversal(
    treeMap: Map<String, Pair<String?, String?>>,
    start: String,
    sb: StringBuilder
) {
    val (left, right) = treeMap[start] ?: null to null

    if (left != null) {
        inorderTraversal(treeMap, left, sb)
    }
    sb.append(start)
    if (right != null) {
        inorderTraversal(treeMap, right, sb)
    }
}

fun postorderTraversal(
    treeMap: Map<String, Pair<String?, String?>>,
    start: String,
    sb: StringBuilder
) {
    val (left, right) = treeMap[start] ?: null to null

    if (left != null) {
        postorderTraversal(treeMap, left, sb)
    }
    if (right != null) {
        postorderTraversal(treeMap, right, sb)
    }
    sb.append(start)
}
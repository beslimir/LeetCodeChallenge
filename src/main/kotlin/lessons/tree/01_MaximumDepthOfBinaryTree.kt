package lessons.tree

import kotlin.math.max

fun main(args: Array<String>) {
    //recursive way
    var treeNode = TreeNode(5)
    treeNode.left = TreeNode(4)
    treeNode.left!!.left = TreeNode(7)
    treeNode.right = TreeNode(2)

    println(maxDepth(treeNode))
}

//recursive way

class TreeNode(var node: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun maxDepth(root: TreeNode?): Int {
    if(root == null) {
        return 0
    }

    return 1 + max(maxDepth(root.left), maxDepth(root.right))
}

//bfd - breadth first search
//fun maxDepthBFD(root: TreeNode?): Int {
//    if(root == null) {
//        return 0
//    }
//
//    var level = 0
//    var counter = 0
//    var queue = ArrayDeque<TreeNode>()
//    queue.add(root)
//
//    while (queue.size > counter) {
//        for (i in 0..queue.size) {
//            var node = queue.removeLast()
//            if (node.left != null) {
//                queue.add(node.left!!)
//            }
//            if (node.right != null) {
//                queue.add(node.right!!)
//            }
//        }
//        counter++
//        level++
//    }
//
//    return level
//}

//DFS - depth first search
//fun maxDepthDFS(root: TreeNode?): Int {
//    return 0
//}
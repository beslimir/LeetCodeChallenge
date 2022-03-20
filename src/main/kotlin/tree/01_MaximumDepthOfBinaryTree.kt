package tree

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


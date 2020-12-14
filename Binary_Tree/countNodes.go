package Binary_Tree


/**
求完全二叉树的节点数跟求二叉树的节点数有区别？？？？
 */
func countNodes(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return sum(countNodes(root.Left), countNodes(root.Right)) + 1

}

func sum(x,y int) int {
	return x+y
}

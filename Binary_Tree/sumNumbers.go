package Binary_Tree


/**
。。。。
 */
func sumNumbers(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return dfs(root, 0)

}

func dfs(node *TreeNode, sum int) int {
	if node == nil {
		return 0
	}
	if node.Left == nil && node.Right == nil {
		return sum+node.Val
	}
	sum = sum+node.Val
	return dfs(node.Left, sum*10) + dfs(node.Right, sum*10)
}

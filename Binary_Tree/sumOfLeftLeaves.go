package Binary_Tree
/**
套路：记住规则
叶子节点：root.Left == nil && root.Right == nil
左叶子节点：root.Left != nil && root.Left.Left == nil && root.Left.Right == nil



digui(root) {

	//递归终止条件
	//dosomething
	digui(root.Left)
	digui(root.Right)
}

 */

func sumOfLeftLeaves(root *TreeNode)  int {
	return dfs(root)
}

func dfs(root *TreeNode)  (sum int) {
	if root == nil {
		return 0
	}
	if root.Left != nil && root.Left.Left == nil && root.Left.Right == nil {
		sum += root.Left.Val
	}

	sum += dfs(root.Left)
	sum += dfs(root.Right)
	return
}
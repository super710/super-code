package Binary_Tree

/**
树的问题一般就是递归了，从低向上，求出左右子树的高度差进行比较
 */


func isBalanced(root *TreeNode) bool {
	if root == nil {
		return true
	}
	return abs(height(root.Right)-height(root.Left)) <= 1 && isBalanced(root.Left) && isBalanced(root.Right)
}

func height(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return maxb(height(root.Right),height(root.Left)) + 1
}

func maxb(x,y int) int {
	if x > y {
		return x
	}
	return y
}

func abs(x int) int {
	if x < 0 {
		return x * -1
	}
	return x
}
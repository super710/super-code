package Binary_Tree
/**
题解：
主要是写出递归终止的条件，然后依次对左右的树进行比较
 */

func isSameTree(p *TreeNode, q *TreeNode) bool {
	if p == nil && q == nil {
		return true
	}
	if p == nil || q == nil {
		return false
	}
	if p.Val != q.Val {
		return false
	}
	return isSameTree(p.Left,q.Left) && isSameTree(p.Right,q.Right)
}
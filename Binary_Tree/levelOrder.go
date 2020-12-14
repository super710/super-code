package Binary_Tree

/**
用数组模拟队列，依次遍历左右子树
*/
func levelOrder(root *TreeNode) []int {
	if root == nil {
		return nil
	}
	res := make([]int, 0)
	queue := []*TreeNode{root}
	for i := 0; i < len(queue); i++ {
		root = queue[i]
		res = append(res, root.Val)
		if root.Left != nil {
			queue = append(queue, root.Left)
		}
		if root.Right != nil {
			queue = append(queue, root.Right)
		}
	}
	return res
}

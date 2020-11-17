package Binary_Tree
/**
跟kthLargest那个题目道理一样
 */

func kthSmallest(root *TreeNode, k int) int {
	if root == nil {
		return 0
	}
	arr := InOrder(root)
	return arr[k-1]
}

func InOrder(node *TreeNode) (arr []int) {
	if node == nil {
		return nil
	}
	arr = append(InOrder(node.Left), node.Val)
	arr = append(arr, InOrder(node.Right)...)
	return arr
}

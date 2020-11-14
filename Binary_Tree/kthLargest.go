package Binary_Tree

/**
二叉树的中序遍历结果就是一个递增的
保存结果到切片中
输出第k大的值
不过效率好低。。。。


执行用时：
20 ms, 在所有 Go 提交中击败了9.05%的用户
内存消耗：8.4 MB, 在所有 Go 提交中击败了5.03%的用户
 */


func kthLargest(root *TreeNode, k int) int {
	if root == nil {
		return 0
	}
	arr := Inorder(root)

	for index, val := range arr {
		if index == len(arr) - k {
			return val
		}
	}
	return 0
}

func Inorder(root *TreeNode) (arr []int)  {
	if root == nil {
		return
	}
	arr = append(Inorder(root.Left), root.Val)
	arr = append(arr, Inorder(root.Right)...)
	return arr
}
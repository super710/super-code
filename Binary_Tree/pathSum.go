package Binary_Tree

/**
与之前的套路一样，确定递归终止的条件为叶子节点的值等于sum
思路很正确，就是go的切片的性质让人无语，最后拷贝切片才能成功
 */


func pathSum(root *TreeNode, sum int) [][]int {
	if root == nil {
		return nil
	}
	var arr [][]int
	var res []int
	pSDFS(root, sum, &arr, res)
	return arr
}

func pSDFS(root *TreeNode, sum int, arr *[][]int, res []int)  {
	if root == nil {
		return
	}

	if root.Left == nil && root.Right == nil && sum == root.Val{
		dst := make([]int, len(res) +1)
		copy(dst, append(res, root.Val))
		*arr = append(*arr, dst)
	}
	res = append(res, root.Val)
	pSDFS(root.Left, sum-root.Val, arr,res)
	pSDFS(root.Right, sum-root.Val,arr, res)
}

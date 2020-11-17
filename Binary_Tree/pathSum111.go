package Binary_Tree

/**
就是之前的pathSum的加强版，取消了叶子节点的限制，而且不一定是从根节点开始的
1：先判断从当前节点开始的和为sum的有几条。
2：依次递归左右两个节点
3：找到后不要停，后面可能还有
 */
func pathSum3(root *TreeNode, sum int) int {
	if root == nil {
		return 0
	}
	var res int
	res = pathSumlll(root,sum)
	return pathSum3(root.Left, sum) + pathSum3(root.Right, sum) + res
}

func pathSumlll(node *TreeNode, sum int)  (res int){
	if node == nil {
		return 0
	}
	if node.Val == sum {
		res++
	}
	res += pathSumlll(node.Left, sum-node.Val)
	res += pathSumlll(node.Right,sum-node.Val)
	return res
}
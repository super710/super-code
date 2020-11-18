package Binary_Tree

/**
这一题与子树那题类似，建议先去看子树的题目
从跟节点开始判断B是否是A的子结构，或则是A左后子树的子结构，满足其一就可，因此用或
递归终止的条件有：

a,b 都到了叶子节点
单独b到了叶子节点
a,b的值不相等

 */
func isSubStructure(A *TreeNode, B *TreeNode) bool {
	if A == nil && B == nil {
		return true
	}
	if A== nil || B == nil {
		return false
	}
	return sameStructure(A,B) || isSubStructure(A.Left, B) || isSubStructure(A.Right, B)
}

func sameStructure(a, b *TreeNode) bool {
	if a == nil && b == nil {
		return true
	}
	if b == nil {
		return true
	}
	if a == nil {
		return false
	}
	if a.Val != b.Val {
		return false
	}
	return sameStructure(a.Left, b.Left) && sameStructure(a.Right, b.Right)
}
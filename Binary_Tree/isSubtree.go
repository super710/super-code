package Binary_Tree
/**
仍是树的一般套路
从根节点开始找，看看这个树是否是自己的子树，只要有不相同的节点，就不是
或则从左右子树开始寻找
 */

func isSubtree(s *TreeNode, t *TreeNode) bool {
	if s == nil && t == nil {
		return true
	}
	if s== nil || t == nil {
		return false
	}

	return samet(s,t) ||  isSubtree(s.Left, t) || isSubtree(s.Right, t)
}

func samet(q,p *TreeNode) bool {
	if q == nil && p == nil {
		return true
	}
	if q== nil || p == nil {
		return false
	}
	if q.Val != p.Val {
		return false
	}
	return (samet(q.Left, p.Left) && samet(q.Right, p.Right))
}
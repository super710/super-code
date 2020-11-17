package Binary_Tree

/**
二叉搜索树的套路，跟节点的值有关系
如果要查找的两个值，一个大于root.Val, 一个小于root.Val则公共祖先就是root
如果都小于，递归左子树
如果都大于，递归右子树
 */

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	if p.Val < root.Val && q.Val < root.Val {
		return lowestCommonAncestor(root.Left, p, q)
	}
	if p.Val > root.Val  && q.Val > root.Val {
		return lowestCommonAncestor(root.Right, p ,q)
	}
	return root

}
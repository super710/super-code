package Binary_Tree


/**
有点投机了，先把左子树或则右子树翻转下，然后比较左右两棵树是否相等
 */


/**
func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}
	root.Left = reverse(root.Left)
	return same(root.Left,root.Right)
}


func same(q,p *TreeNode) bool {
	if q == nil && p == nil {
		return true
	}
	if q == nil || p == nil {
		return false
	}
	if q.Val != p.Val {
		return false
	}
	return same(q.Left, p.Left) && same(q.Right,p.Right)
}

func reverse(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	left := reverse(root.Left)
	right := reverse(root.Right)
	root.Left = right
	root.Right = left
	return root
}

 */

/**
方法二
就是和两个相同的二叉树那题思路是一样的，相同的二叉树比较q.Left和p.Left，而这里镜像的话就是q.Left和p.Right比较了
但是这种效率反而更低。。。。
 */

func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}

	return same(root.Left,root.Right)
}


func same(q,p *TreeNode) bool {
	if q == nil && p == nil {
		return true
	}
	if q == nil || p == nil {
		return false
	}
	if q.Val != p.Val {
		return false
	}
	return same(q.Left, p.Right) && same(q.Right,p.Left)
}
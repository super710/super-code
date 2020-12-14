package Binary_Tree

func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 || len(preorder) > 5000 {
		return nil
	}
	root := &TreeNode{
		Val: preorder[0],
	}
	var index int
	for i, v := range inorder {
		if v == root.Val {
			index = i
			break
		}
	}
	root.Left = buildTree(preorder[1:index+1], inorder[:index])
	root.Right = buildTree(preorder[index+1:], inorder[index+1:])
	return root
}

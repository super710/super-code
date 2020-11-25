package Binary_Tree
/**
递归
后续遍历的性质，根节点在切片的最后一位

 */
func verifyPostorder(postorder []int) bool {
	if len(postorder) == 0 {
		return true
	}
	f := len(postorder)-1
	for i := 0; i < len(postorder); i++ {
		if postorder[i] >= postorder[len(postorder)-1] {
			f = i
		}
		if i > f && postorder[i] < postorder[len(postorder)-1] {
			return false
		}
	}
	return verifyPostorder(postorder[:f]) && verifyPostorder(postorder[f:len(postorder)-1])
}


//方法二：更容易理解
/**
如果切片<=1,肯定是true
先找到每棵树的根节点 root = postorder[len(postorder) - 1]，同时找到第一个大于root的值index作为左右子树的分割点
确定左右子树：leftArr := postorder[:index]，rigth := postorder[index:len(postorder)-1]
不为二叉树的条件就是左子树的值大于根节点，右子树的小于根节点
递归判断左右子树
 */

func verifyPostorder2(postorder []int) bool {
	if len(postorder) <=1 {
		return true
	}
	root := postorder[len(postorder) - 1]
	var index = 0
	for i, v := range postorder {
		if v >= root {
			index = i
			break
		}
	}
	leftArr := postorder[:index]
	rigth := postorder[index:len(postorder)-1]
	for _,v := range leftArr {
		if v > root {
			return false
		}
	}
	for _,v := range rigth {
		if v < root {
			return false
		}
	}
	return verifyPostorder(leftArr) && verifyPostorder(rigth)
}

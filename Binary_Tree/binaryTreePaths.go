package Binary_Tree

/**
这一题写的真的坎坷，花了一个多小时。。。。。
思路没错，就是再一些细节上有问题，比如string和int之间的转换应该借助strconv.Itoa函数，不应该直接string(int)
切片扩容会导致地址的变换，导致返回[], 应该参数切片的对象的地址


具体思路：
确定递归终止的条件：叶子节点或则为空
具体做什么： 完成拼接，加入切片
*/

import "strconv"
func binaryTreePaths(root *TreeNode) []string {
	if root == nil {
		return nil
	}
	var arr []string
	dfsbTP(root, &arr, "")
	return arr
}

func dfsbTP(node *TreeNode, arr *[]string, str string) {
	if node == nil {
		return
	}
	if node.Left == nil && node.Right == nil {
		str += strconv.Itoa(node.Val)
		*arr = append(*arr, str)
	}
	dfsbTP(node.Left, arr, str+strconv.Itoa(node.Val)+"->")
	dfsbTP(node.Right, arr, str+strconv.Itoa(node.Val)+"->")
}

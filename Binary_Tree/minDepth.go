package Binary_Tree

import "math"

/**
题解：表面上看与求最大深度类似，其实要注意的是从根节点到叶子节点的
要判断最后的节点是否是叶子节点

 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func minDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	if root.Left == nil && root.Right == nil {
		return 1
	}
	minVal := math.MaxInt32
	if root.Left != nil {
		minVal = min(minDepth(root.Left),minVal)
	}
	if root.Right != nil {
		minVal = min(minDepth(root.Right), minVal)
	}
	return minVal + 1

}


func min(x,y int) int {
	if x > y {
		return y
	}
	return x
}
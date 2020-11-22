package Binary_Tree

/**
跟层序遍历的输出类似，就是要确定输出的层数，可以用一个临时队列来保存
*/

func levelOrder11(root *TreeNode) [][]int {
	if root == nil {
		return nil
	}
	var res [][]int
	var queue = []*TreeNode{root}
	var level = 0
	for len(queue) != 0 {
		tmpqueue := []*TreeNode{}
		res = append(res, []int{})
		for _, v := range queue {
			res[level] = append(res[level], v.Val)
			if v.Left != nil {
				tmpqueue = append(tmpqueue, v.Left)
			}
			if v.Right != nil {
				tmpqueue = append(tmpqueue, v.Right)
			}
		}
		level = level + 1
		queue = tmpqueue
	}
	return res

}

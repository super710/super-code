package Binary_Tree

/**
本题就是在11的基础上判断层数的奇偶，奇数层倒着加入切片，偶数层正着加入切片
 */
func levelOrder111(root *TreeNode) [][]int {
	if root == nil {
		return nil
	}
	var res [][]int
	var queue = []*TreeNode{root}
	var level = 0
	for len(queue) != 0 {
		res = append(res, []int{})
		var tmpqueue []*TreeNode
		for i:=0;i<len(queue);i++{
			if level %2 == 0 {
				res[level] = append(res[level],queue[i].Val)
			} else {
				res[level] = append(res[level], queue[len(queue)-1-i].Val)
			}
			if queue[i].Left != nil {
				tmpqueue = append(tmpqueue,queue[i].Left)
			}
			if queue[i].Right != nil {
				tmpqueue = append(tmpqueue, queue[i].Right)
			}
		}
		level = level +1
		queue = tmpqueue
	}
	return res
}
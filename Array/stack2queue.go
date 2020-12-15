package Array

//定义两个栈模拟队列
type CQueue struct {
	s1 []int
	s2 []int
}

func Constructor() CQueue {
	s1 := make([]int, 0)
	s2 := make([]int, 0)
	return CQueue{
		s1, s2,
	}
}

//添加的时候添加到s1的队尾
func (this *CQueue) AppendTail(value int) {
	this.s1 = append(this.s1, value)
}

//删除的时候先判断s2是否为空，为空的话把s1的全部放到到s2
func (this *CQueue) DeleteHead() int {
	if len(this.s2) == 0 {
		if len(this.s1) == 0 {
			return -1
		}
		for len(this.s1) != 0 {
			index := len(this.s1) - 1
			this.s2 = append(this.s2, this.s1[index])
			this.s1 = this.s1[:index]
		}
	}
	//s2取出最后一个元素
	index := len(this.s2) - 1
	res := this.s2[index]
	this.s2 = this.s2[:index]
	return res
}

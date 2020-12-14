package Array

/**
遍历数组，超过两次就删除，同时下标也要减1
*/
func removeDuplicates(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	var i, count = 1, 1
	for i < len(nums) {
		if nums[i] == nums[i-1] {
			count++
			if count > 2 {
				nums = append(nums[:i], nums[i+1:]...)
				i-- //此处最为细节，因为删除了一个元素，所以i--，坑了我十几分钟。。。。
			}
		} else {
			count = 1
		}
		i++

	}
	return i
}

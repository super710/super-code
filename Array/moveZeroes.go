package Array

/**
找到第一个为0的下标
从此下标找到第一个不为0的下标
交换这两个值
*/
func moveZeroes(nums []int) {
	if len(nums) == 0 {
		return
	}

	for index, val := range nums {
		if val == 0 {
			for i := index + 1; i < len(nums); i++ {
				if nums[i] != 0 {
					nums[index], nums[i] = nums[i], nums[index]
					break
				}
			}
		}

	}
}

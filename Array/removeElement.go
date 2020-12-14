package Array

func removeElement(nums []int, val int) int {
	if len(nums) == 0 {
		return 0
	}
	for index, value := range nums {
		if value == val {
			for i := index + 1; i < len(nums); i++ {
				if nums[i] != val {
					nums[index], nums[i] = nums[i], nums[index]
					break
				}
			}
		}
	}
	var res int
	for _, value := range nums {
		if value != val {
			res++
		}
	}
	return res
}

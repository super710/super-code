package Array

/**
简单的不想说，双百
 */
func search(nums []int, target int) int {
	if len(nums) == 0 {
		return 0
	}
	sum :=0
	for _, val := range nums {
		if val == target {
			sum++
		}
	}
	return sum
}

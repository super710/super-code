package Array
/**
基本题目
 */
func missingNumber(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	total := len(nums)*(len(nums)+1)/2
	sum := 0
	for _, val := range nums {
		sum += val
	}
	return total - sum
}

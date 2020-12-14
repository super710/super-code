package Array

func majorityElement(nums []int) int {
	if len(nums) == 1 {
		return nums[0]
	}
	res := make(map[int]int, len(nums))
	for _, v := range nums {
		if _, ok := res[v]; ok != true {
			res[v] = 1
		} else {
			res[v]++
			if res[v] > len(nums)/2 {
				return v
			}
		}
	}
	return 0
}

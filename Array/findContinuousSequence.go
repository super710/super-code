package Array

/**
1. 小于二直接返回
2. 左右指针开始同时指向第一个元素
3. 小于target时，right指针+1
4. 等于target时，直接加入数组
5. 大于target时，sum减去left指针所指向的值，left指针向右移动1，循环判断sum是否等于target，直到小于target
*/

func findContinuousSequence(target int) [][]int {
	if target <= 2 {
		return nil
	}
	res := make([][]int, 0)
	arr := make([]int, 0)
	for i := 1; i <= target/2+1; i++ {
		arr = append(arr, i)
	}
	var left, right = 0, 0
	var sum = 0
	for i := left; i <= right && right < len(arr); i++ {
		sum = sum + arr[i]
		if sum < target {
			right++
		} else {
			if sum == target {
				res = append(res, arr[left:right+1])
				right++
			} else {
				for sum > target {
					sum = sum - arr[left]
					left++
					if sum == target {
						res = append(res, arr[left:right+1])
					}

				}
				right++

			}
		}
	}
	return res
}

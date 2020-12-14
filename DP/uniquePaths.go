/**
动态规划三步骤
定义数组元素
找出初始值
找出关系
*/

func uniquePaths(m int, n int) int {
	dp := make([][]int, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]int, m)
	}
	dp[0][0] = 1
	for i := 1; i < m; i++ {
		dp[0][i] = 1
	}
	for i := 1; i < n; i++ {
		dp[i][0] = 1
	}

	for i := 1; i < n; i++ {
		for j := 1; j < m; j++ {
			dp[i][j] = dp[i-1][j] + dp[i][j-1]
		}
	}
	return dp[n-1][m-1]
}
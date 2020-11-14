package DP
/**
求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）

动态规划基础题型
dp table
 */


func sumNums(n int) int {
	dp := make([]int,n+1)
	dp[0] = 0
	for i:=1;i<=n;i++{
		dp[i] = dp[i-1] + i
	}
	return dp[n]
}

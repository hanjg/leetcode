package dp;

/**
 * problems-70 https://leetcode.cn/problems/climbing-stairs/
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        //dp[i]：到达i层的路径数量
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            //到第i层可能从i-1层也可能从i-2层
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}

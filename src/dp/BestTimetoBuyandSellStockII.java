package dp;

/**
 * problems-122 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimetoBuyandSellStockII {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        //dp[i][0]：第i天空仓利润；dp[i][1]：第i天满仓利润
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 由于只依赖dp[i-1][?]的数据，空间复杂度可以降为O(1)
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        //前一天空仓利润
        int dp0 = 0;
        //前一天满仓利润
        int dp1 = -prices[0];
        for (int i = 1; i < n; i++) {
            int t0 = Math.max(dp0, dp1 + prices[i]);
            int t1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = t0;
            dp1 = t1;
        }
        return dp0;
    }
}

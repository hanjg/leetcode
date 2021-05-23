package dp;

/**
 * problems-188 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class BestTimetoBuyandSellStockIV {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        if (k >= n / 2) {
            //n天最多进行n/2笔交易，超过相当于k没有限制
            int max = 0;
            for (int i = 0; i + 1 < n; i++) {
                if (prices[i] < prices[i + 1]) {
                    max += prices[i + 1] - prices[i];
                }
            }
            return max;
        }
        //dp[i][j][0]：第i天j次交易空仓
        //dp[i][j][1]：第i天j次交易满仓
        int[][][] dp = new int[n][k + 1][2];
        for (int j = 0; j <= k; j++) {
            dp[0][j][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                //空仓：昨天空仓||昨天满仓，今天卖出
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                //满仓：昨天满仓||昨天空仓，今天买入
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }
}

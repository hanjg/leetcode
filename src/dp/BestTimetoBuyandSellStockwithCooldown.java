package dp;

/**
 * problems-309 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimetoBuyandSellStockwithCooldown {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        //昨天空仓利润
        int dp0 = 0;
        //昨天满仓利润
        int dp1 = Integer.MIN_VALUE;
        //前天空仓利润
        int dpPre0 = 0;
        for (int i = 0; i < n; i++) {
            int t0 = Math.max(dp0, dp1 + prices[i]);
            int t1 = Math.max(dp1, dpPre0 - prices[i]);
            dpPre0 = dp0;
            dp0 = t0;
            dp1 = t1;
        }
        return dp0;
    }

}

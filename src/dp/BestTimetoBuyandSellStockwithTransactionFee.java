package dp;

/**
 * problems-714 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class BestTimetoBuyandSellStockwithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        //前一天空仓利润
        int dp0 = 0;
        //前一天满仓利润
        int dp1 = -prices[0];
        for (int i = 1; i < n; i++) {
            int t0 = Math.max(dp0, dp1 + prices[i] - fee);
            int t1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = t0;
            dp1 = t1;
        }
        return dp0;
    }
}

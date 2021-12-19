package weekly;

/**
 * @author anxi
 * @version 2021/12/19 10:44
 */
public class GetDescentPeriods {

    public long getDescentPeriods(int[] prices) {
        //dp[i];下标i结尾的平滑下降数量
        //long防止溢出
        long sum = 0;
        long[] dp = new long[prices.length];
        for (int i = 0; i < prices.length; i++) {
            dp[i] = 1;
            if (i > 0 && prices[i - 1] - prices[i] == 1) {
                dp[i] += dp[i - 1];
            }
            sum += dp[i];
        }
        return sum;
    }
}

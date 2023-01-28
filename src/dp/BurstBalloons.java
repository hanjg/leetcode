package dp;

/**
 * problems-312 https://leetcode-cn.com/problems/burst-balloons/
 */
public class BurstBalloons {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int m = n + 2;
        //补充两个价值1，无法戳破的气球
        int[] money = new int[m];
        money[0] = money[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            money[i + 1] = nums[i];
        }
        //dp[i][j]，戳破money(i,j)之间所有气球可获得的最大值，目标dp[0][m-1]
        int[][] dp = new int[m][m];
        //offset=j-i
        for (int offset = 2; offset < m; offset++) {
            for (int i = 0, j = i + offset; j < m; i++, j++) {
                //最后一个戳破的气球可能是(i,j)中的任意一个。
                for (int last = i + 1; last < j; last++) {
                    //分治思想
                    dp[i][j] = Math.max(dp[i][j], dp[i][last] + dp[last][j] + money[last] * money[i] * money[j]);
                }
            }
        }
        return dp[0][m - 1];
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        System.out.println(new BurstBalloons().maxCoins(nums));
    }
}

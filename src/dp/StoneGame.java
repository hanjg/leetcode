package dp;

/**
 * problems-877 https://leetcode-cn.com/problems/stone-game/
 */
public class StoneGame {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            dp[i][i][0] = piles[i];
        }
        //dp[i][j][0]：先手 = 先手拿左边dp[i+1][j][1]+piles[i] || 先手拿右边dp[i][j-1][1]+piles[j]
        //dp[i][j][1]：后手 = 先手拿左边dp[i+1][j][0] || 先手拿右边dp[i][j-1][0]
        for (int offset = 1; offset < n; offset++) {
            for (int i = 0; i + offset < n; i++) {
                int j = i + offset;
                int leftMax = dp[i + 1][j][1] + piles[i];
                int rightMax = dp[i][j - 1][1] + piles[j];
                if (leftMax > rightMax) {
                    //先手拿左边
                    dp[i][j][0] = leftMax;
                    dp[i][j][1] = dp[i + 1][j][0];
                } else {
                    //先手拿右边
                    dp[i][j][0] = rightMax;
                    dp[i][j][1] = dp[i][j - 1][0];
                }
            }
        }
        return dp[0][n - 1][0] > dp[0][n - 1][1];
    }
}

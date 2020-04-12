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
        //dp[i][j][0]：piles[i,j]先手能获得的最高分数
        // 作为先手 = 先手拿左边piles[i]+剩下的后手dp[i+1][j][1] || 先手拿右边piles[j]+剩下的后手dp[i][j-1][1]
        //dp[i][j][1]：piles[i,j]后手能获得的最高分数
        // 作为后手 = 如果先手拿左边,剩下的先手dp[i+1][j][0] ; 如果先手拿右边，剩下的先手dp[i][j-1][0]
        for (int offset = 1; offset < n; offset++) {
            for (int i = 0, j = i + offset; j < n; i++, j = i + offset) {
                //选取[i,j]：先手两种选择的结果
                int leftMax = piles[i] + dp[i + 1][j][1];
                int rightMax = piles[j] + dp[i][j - 1][1];
                if (leftMax > rightMax) {
                    //先手决定拿左边
                    dp[i][j][0] = leftMax;
                    dp[i][j][1] = dp[i + 1][j][0];
                } else {
                    //先手决定拿右边
                    dp[i][j][0] = rightMax;
                    dp[i][j][1] = dp[i][j - 1][0];
                }
            }
        }
        return dp[0][n - 1][0] > dp[0][n - 1][1];
    }
}

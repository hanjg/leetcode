package dp;

/**
 * problems-72 https://leetcode-cn.com/problems/edit-distance/
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //dp[i][j]: word1[0,i)->word2[0,j)的最小次数
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            //都删除
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            //都新增
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    //最后一个字符相等，不操作
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //对B增、删、改 等价于 对B增、对A增、对A改
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[m][n];
    }
}

package dp;

/**
 * problems-1143 https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        //dp[i][j]: word1[0,i)和word2[0,j)的最长公共子序列长度
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    //两个字符都在lcs中
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //两个字符至少有一个不在lcs中：text1[i-1]不在；text2[j-1]不在
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

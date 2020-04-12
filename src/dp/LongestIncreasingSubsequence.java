package dp;

/**
 * problems-300 https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        //dp[i]:当前长度为i的序列最小结尾数字
        int[] dp = new int[n + 1];
        //当前最长序列长度
        int len = 1;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            int index = findLeft(dp, 1, len, nums[i - 1]);
            if (index == -1) {
                //无左边界,dp[1,len]<num[i-1]，最长递增子序列长度+1
                dp[++len] = nums[i - 1];
            } else {
                //有左边界，nums[i-1]替换该左边界值，最长递增子序列长度不变
                dp[index] = nums[i - 1];
            }
        }
        return len;
    }

    /**
     * 第一个>=target的下标，即寻找左边界
     */
    private int findLeft(int[] dp, int l, int r, int target) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (dp[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return dp[l] >= target ? l : -1;
    }

    public static void main(String[] args) {
        int i = new LongestIncreasingSubsequence().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
        System.out.println(i);
    }
}

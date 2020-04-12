package dp;

/**
 * problems-213 https://leetcode-cn.com/problems/house-robber-ii/
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1){
            return nums[0];
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    private int rob(int[] nums, int begin, int end) {
        if (end - begin < 0) {
            return 0;
        }
        if (begin == end) {
            return nums[begin];
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[begin] = nums[begin];
        dp[begin + 1] = Math.max(nums[begin], nums[begin + 1]);
        for (int i = begin + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }

}

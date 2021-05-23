package dp;

/**
 * problems-152 https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int res = nums[0];

        //dp[i][0]:以nums[i]结尾的最大乘积子数组正数大值
        //dp[i][1]:以nums[i]结尾的最大乘积子数组负数最小值
        int[][] dp = new int[n][2];
        if (nums[0] > 0) {
            dp[0][0] = nums[0];
        } else if (nums[0] < 0) {
            dp[0][1] = nums[0];
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] >= 0) {
                dp[i][0] = Math.max(nums[i], dp[i - 1][0] * nums[i]);
                dp[i][1] = dp[i - 1][1] * nums[i];
            } else {
                dp[i][0] = dp[i - 1][1] * nums[i];
                dp[i][1] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
            }
            res = Math.max(res, dp[i][0]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, -1, -2, 2, 1, -2, 1};
        System.out.println(new MaximumProductSubarray().maxProduct(nums));
    }

}

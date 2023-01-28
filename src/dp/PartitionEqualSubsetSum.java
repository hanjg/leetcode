package dp;

/**
 * problems-416 https://leetcode.cn/problems/partition-equal-subset-sum/
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int max = sum / 2;
        // dp[i][j]: nums[0,i)子集合元素和不超过j的最大值。01背包二维动规
        int[][] dp = new int[n + 1][max + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= max; j++) {
                if (nums[i - 1] > j) {
                    // nums[i-1]不加入背包
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // nums[i-1]可能加入也可能不加入背包，取最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                }
            }
        }
        return dp[n][max] == max;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[]{1, 2, 3, 5}));
    }
}

package dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/combination-sum-iv/
 */
public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        //dp[i]: 目标和是i的组合数量
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            //考虑集合中最后一个数字
            for (int last : nums) {
                if (last > i) {
                    continue;
                }
                //最后一个数字是last
                dp[i] += dp[i - last];
            }
        }
        return dp[target];
    }

}

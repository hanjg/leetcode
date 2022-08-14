package weekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author anxi
 * @version 2022/5/8 10:44
 */
public class Week1 {

    public boolean validPartition(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return equal2(nums, 1);
        }

        boolean[] dp = new boolean[n];//nums[0,i)
        dp[1] = equal2(nums, 1);
        dp[2] = equal3(nums, 2) || incr(nums, 2);
        for (int i = 3; i < n; i++) {
            dp[i] |= equal2(nums, i) && dp[i - 2];
            dp[i] |= equal3(nums, i) && dp[i - 3];
            dp[i] |= incr(nums, i) && dp[i - 3];
        }
        return dp[n - 1];
    }

    private boolean equal3(int[] nums, int i) {
        return nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2];
    }

    private boolean equal2(int[] nums, int i) {
        return nums[i] == nums[i - 1];
    }

    private boolean incr(int[] nums, int i) {
        return nums[i] == 1 + nums[i - 1] && nums[i - 1] == 1 + nums[i - 2];
    }

    public static void main(String[] args) {
        System.out.println(new Week1().validPartition(new int[]{10, 20, 30}));
    }
}

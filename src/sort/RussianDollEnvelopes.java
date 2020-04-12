package sort;

import java.util.Arrays;

/**
 * problems-354 https://leetcode-cn.com/problems/russian-doll-envelopes/
 */
public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n <= 1) {
            return n;
        }
        //按宽度小到大，同宽度按高度大到小。
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });
        //求宽度的最长递增子序列，保证不同宽度可以嵌套，同宽度只会取到最小高度嵌套
        int[] nums = Arrays.stream(envelopes).map(env -> env[1]).mapToInt(Integer::valueOf).toArray();
        return lengthOfLIS(nums);
    }

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
                //dp[x]<target
                dp[++len] = nums[i - 1];
            } else {
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
        System.out.println(new RussianDollEnvelopes().maxEnvelopes(new int[][]
                {{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    }
}

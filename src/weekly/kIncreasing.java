package weekly;

/**
 * https://leetcode-cn.com/contest/weekly-contest-272/problems/minimum-operations-to-make-the-array-k-increasing/
 */
public class kIncreasing {

    public int kIncreasing(int[] arr, int k) {
        int n = arr.length;
        int minGroupLen = n / k;
        int smallerGroupIndex = 0;
        if (n > k * minGroupLen) {
            smallerGroupIndex = n - k * minGroupLen;
        }

        int sum = 0;
        for (int group = 0; group < k; group++) {
            //分为K组
            int len = group < smallerGroupIndex ? minGroupLen + 1 : minGroupLen;
            int[] arr1 = new int[len];
            for (int i = 0; i < len; i++) {
                arr1[i] = arr[group + i * k];
            }
            //求LIS长度
            int lisLen = lengthOfLIS(arr1);
            int op = len - lisLen;
            sum += op;
        }
        return sum;
    }

    /**
     * 最长非递减子序列长度(类似于最长递增子子序列)
     */
    private int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        //dp[i]:长度为i的LIS末尾元素最小值
        int[] dp = new int[n + 1];
        //当前最长子序列长度
        int max = 1;
        dp[max] = nums[0];
        //len:父串长度
        for (int len = 2; len <= n; len++) {
            int target = nums[len - 1];
            int index = findLeft(dp, 1, max, target);
            if (index == -1) {
                //无左边界,dp[1,len]<num[len-1]，最长递增子序列长度+1
                dp[++max] = target;
            } else {
                //有左边界，即dp[index]>nums[len-1]，替换该左边界值，最长递增子序列长度不变
                dp[index] = target;
            }
        }
        return max;
    }

    /**
     * 第一个>target的下标，即寻找左边界
     */
    private int findLeft(int[] dp, int l, int r, int target) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (dp[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return dp[l] > target ? l : -1;
    }

    public static void main(String[] args) {
        System.out.println(new kIncreasing().kIncreasing(new int[]{4, 1, 5, 2, 6, 2}, 2));
    }
}

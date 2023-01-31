package weekly;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-swaps-to-group-all-1s-together-ii/
 */
public class MinimumSwapstoGroupAll1sTogetherII {

    /**
     * 定长滑动窗口。最小交换次数转化为：求从i开始宽度为k的窗口，0个数最少，即区间和最大
     */
    public int minSwaps(int[] nums) {
        //总共k个1
        int k = Arrays.stream(nums).sum();
        int n = nums.length;
        //环形数组计算两倍区间和,sum[i]=num[0,i)
        int[] sum = new int[n * 2 + 1];
        for (int i = 1; i < 2 * n + 1; i++) {
            sum[i] = sum[i - 1] + nums[(i - 1) % n];
        }
        int left = 0;
        int countZero = Integer.MAX_VALUE;
        while (left + k < 2 * n) {
            countZero = Math.min(countZero, k - (sum[left + k] - sum[left]));
            left++;
        }
        return countZero;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumSwapstoGroupAll1sTogetherII().minSwaps(new int[]{1, 1, 1, 0, 0, 1, 0, 1, 1, 0}));
        ;
    }
}

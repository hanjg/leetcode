package sort;

/**
 * problems-164 https://leetcode-cn.com/problems/maximum-gap/
 */
public class MaximumGap {

    public int maximumGap(int[] nums) {//桶排序思想
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int n = nums.length;
        int maxNum = nums[0];
        int minNum = nums[0];
        for (int i = 1; i < n; i++) {
            maxNum = Math.max(maxNum, nums[i]);
            minNum = Math.min(minNum, nums[i]);
        }
        //所有数都一样，无间隔
        if (maxNum == minNum) {
            return 0;
        }

        //总共分n个桶，宽度width，最后一个桶
        int width = (int) Math.ceil((double) (maxNum - minNum) / (n - 1));
        //edges[i][0]:i桶里的数最小值，edges[i][1]：i桶里的数最大值
        int[][] edges = new int[n][2];
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[0].length; j++) {
                edges[i][j] = -1;
            }
        }

        for (int num : nums) {
            int index = (num - minNum) / width;
            if (edges[index][0] == -1) {
                edges[index][0] = num;
            }
            if (edges[index][1] == -1) {
                edges[index][1] = num;
            }
            edges[index][0] = Math.min(edges[index][0], num);
            edges[index][1] = Math.max(edges[index][1], num);
        }
        int maxGap = 0;
        int preMax = -1;
        for (int[] edge : edges) {
            //和前一个桶比较
            if (preMax != -1) {
                maxGap = Math.max(maxGap, edge[0] - preMax);
            }
            //桶内部比较
            maxGap = Math.max(maxGap, edge[1] - edge[0]);
            if (edge[1] != -1) {
                preMax = edge[1];
            }
        }
        return maxGap;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumGap().maximumGap(new int[]{3, 6, 9, 1}));
        System.out.println(new MaximumGap().maximumGap(new int[]{1, 1000000}));
    }
}

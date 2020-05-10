package array;

/**
 * problems-769 https://leetcode-cn.com/problems/max-chunks-to-make-sorted/description/
 */
public class MaxChunksToMakeSorted {

    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int leftMax = Integer.MIN_VALUE;
        //下标i==arr[0,i]最大值，[0,i]可以作为有序的一块
        for (int i = 0; i < arr.length; i++) {
            leftMax = Math.max(leftMax, arr[i]);
            if (i == leftMax) {
                count++;
            }
        }
        return count;
    }
}

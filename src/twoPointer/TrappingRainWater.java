package twoPointer;

/**
 * problems-42 https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * @see heap.TrappingRainWaterII
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int sum = 0;
        int left = 0;
        int right = height.length - 1;
        //[0,left)最大值
        //(right,length-1]的最大值
        int leftmax = height[left];
        int rightmax = height[right];
        while (left <= right) {
            //接水的高度由短板决定
            leftmax = Math.max(leftmax, height[left]);
            rightmax = Math.max(rightmax, height[right]);
            if (leftmax < rightmax) {
                sum += Math.max(0, leftmax - height[left]);
                left++;
            } else {
                sum += Math.max(0, rightmax - height[right]);
                right--;
            }
        }
        return sum;
    }

}

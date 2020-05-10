package twoPointer;

/**
 * problems-42 https://leetcode-cn.com/problems/trapping-rain-water/
 * @see heap.TrappingRainWaterII
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int sum = 0;
        int left = 0;
        int right = height.length - 1;
        //[0,left)最大值
        int leftmax = 0;
        //(right,length-1]的最大值
        int rightmax = 0;
        while (left <= right) {
            leftmax = Math.max(leftmax, height[left]);
            rightmax = Math.max(rightmax, height[right]);
            //接水的高度由短板决定
            if (leftmax < rightmax) {
                sum += Math.max(0, Math.min(leftmax, rightmax) - height[left]);
                left++;
            } else {
                sum += Math.max(0, Math.min(leftmax, rightmax) - height[right]);
                right--;
            }
        }
        return sum;
    }

}

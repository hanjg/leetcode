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
        int leftBar = height[left];
        int rightBar = height[right];
        while (left < right) {
            //接水的高度由短板决定
            if (leftBar < rightBar) {
                int target = left + 1;
                sum += Math.max(0, leftBar - height[target]);
                leftBar = Math.max(leftBar, height[target]);
                left++;
            } else {
                int target = right - 1;
                sum += Math.max(0, rightBar - height[target]);
                rightBar = Math.max(rightBar, height[target]);
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

}

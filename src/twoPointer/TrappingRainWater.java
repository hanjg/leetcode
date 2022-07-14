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
                sum += Math.max(0, leftBar - height[left + 1]);
                leftBar = Math.max(leftBar, height[++left]);
            } else {
                sum += Math.max(0, rightBar - height[right - 1]);
                rightBar = Math.max(rightBar, height[--right]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

}

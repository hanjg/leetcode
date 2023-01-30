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
        int effectiveLeft = height[left]; //左边的有效高度
        int effectiveRight = height[right]; //右边的有效高度
        while (left < right) {
            //接水的高度由短板决定
            if (effectiveLeft < effectiveRight) {
                int target = left + 1;
                sum += Math.max(0, effectiveLeft - height[target]);
                effectiveLeft = Math.max(effectiveLeft, height[target]);
                left++;
            } else {
                int target = right - 1;
                sum += Math.max(0, effectiveRight - height[target]);
                effectiveRight = Math.max(effectiveRight, height[target]);
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

}

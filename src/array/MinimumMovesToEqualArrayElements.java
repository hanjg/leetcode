package array;

import java.util.Arrays;

/**
 * problems-453 https://leetcode.cn/problems/minimum-moves-to-equal-array-elements/
 */
public class MinimumMovesToEqualArrayElements {

    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int result = 0;
        for (int num : nums) {
            result += num - min;
        }
        return result;
    }
}

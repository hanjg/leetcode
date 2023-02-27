package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * problems-452 https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class MinimumNumberofArrowstoBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        //箭数量
        int count = 1;
        //箭位置
        int end = points[0][1];
        for (int[] point : points) {
            if (point[0] <= end) {
                continue;
            }
            count++;
            end = point[1];
        }
        return count;
    }
}

package greedy;


import java.util.Arrays;
import java.util.Comparator;

/**
 * problems-435 https://leetcode-cn.com/problems/non-overlapping-intervals/
 */
public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int maxNonOverLappingCount = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            maxNonOverLappingCount++;
            end = intervals[i][1];
        }
        return intervals.length - maxNonOverLappingCount;
    }
}

package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * problems-56 https://leetcode-cn.com/problems/merge-intervals/
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        List<int[]> res = new ArrayList<>();
        //intervals中的区间按照start从小到大排序
        intervals = Arrays.stream(intervals).sorted(Comparator.comparingInt(o -> o[0])).collect(Collectors.toList())
                .toArray(new int[0][0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            //由于已经排序，interval.start>=start
            if (interval[0] <= end) {
                //可以合并，interval.start<=end
                end = Math.max(end, interval[1]);
            } else {
                //不可合并
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][0]);
    }
    class Interval {
        int start;
        int end;
        Interval() {
            start = 0; end = 0;
        }
        Interval(int s, int e) {
            start = s; end = e;
        }
    }
    public static void main(String[] args) {
        new MergeIntervals().merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }
}


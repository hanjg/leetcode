package sort;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * problems-352 https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/
 */
public class DataStreamasDisjointIntervals {

    public class SummaryRanges {

        private TreeSet<Interval> set;

        public SummaryRanges() {
            //按照开始排序
            set = new TreeSet<>(Comparator.comparingInt(o -> o.start));
        }

        public void addNum(int val) {
            Interval newInterval = new Interval(val, val);
            Interval floor = set.floor(newInterval);
            Interval higher = set.higher(newInterval);
            if (floor != null && floor.end >= val) {
                //包含于已有区间
                return;
            }
            if (floor != null && floor.end + 1 == val) {
                //合并区间
                newInterval.start = floor.start;
                set.remove(floor);
            }
            if (higher != null && val + 1 == higher.start) {
                //合并区间
                newInterval.end = higher.end;
                set.remove(higher);
            }
            set.add(newInterval);
        }

        public int[][] getIntervals() {
            int[][] res = new int[set.size()][2];
            int i = 0;
            for (Interval interval : set) {
                res[i][0] = interval.start;
                res[i][1] = interval.end;
                i++;
            }
            return res;
        }
    }

    /**
     * Definition for an interval. public class Interval { int start; int end; Interval() { start = 0; end = 0; }
     * Interval(int s, int e) { start = s; end = e; } }
     */
    class Interval {

        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

}

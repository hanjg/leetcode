package sort;
import java.util.*;
import sort.MergeIntervals.Interval;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> res=new ArrayList<>();
    	int cur;
    	for(cur=0;cur<intervals.size();cur++){
    		Interval interval=intervals.get(cur);
 //比较newInterval和interval考虑是否合并,合并则用结果代表newInterval，不合并则加入较小的一个区间
    		if (newInterval.end<interval.start) {
				res.add(newInterval);newInterval=interval;
				break;
			}
    		else if (newInterval.end<=interval.end) {
				newInterval.start=Math.min(newInterval.start, interval.start);
				newInterval.end=interval.end;
				break;
			}
    		else if (newInterval.start<=interval.end) {//无法确定newInterval.end和之后一个区间的关系，不break;
				newInterval.start=Math.min(newInterval.start, interval.start);
			}
    		else {
				res.add(interval);
			}
    	}
    	res.add(newInterval);
    	for(cur=cur+1;cur<intervals.size();cur++) res.add(intervals.get(cur));
    	return res;
    }

}

package sort;
import java.util.*;
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

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> res=new ArrayList<>();
    	if(intervals.size()==0)return res;
    	Collections.sort(intervals, new Comparator<Interval>() {
    		public int compare(Interval i1,Interval i2){
    			return i1.start-i2.start;
    		}
		});//intervals中的区间按照start从小到大排序
    	int start=intervals.get(0).start,end=intervals.get(0).end;
    	//待合并的区间[start,end],由于intervals的顺序，start<=新的区间的start
    	for(Interval interval:intervals){
    		if (interval.start<=end) {//可以合并
    			end=Math.max(end, interval.end);
			}
    		else {//不可合并
				res.add(new Interval(start, end));
				start=interval.start;end=interval.end;
			}
    	}
    	res.add(new Interval(start, end));
    	return res;
    }
}

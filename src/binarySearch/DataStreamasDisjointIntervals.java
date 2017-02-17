package binarySearch;
import java.util.*;
public class DataStreamasDisjointIntervals {
	/**
	 * Definition for an interval.
	 * public class Interval {
	 *     int start;
	 *     int end;
	 *     Interval() { start = 0; end = 0; }
	 *     Interval(int s, int e) { start = s; end = e; }
	 * }
	 */
	class Interval {
		     int start;
		     int end;
		     Interval() { start = 0; end = 0; }
		     Interval(int s, int e) { start = s; end = e; }
	}
	public class SummaryRanges {

		private TreeSet<Interval> set;
	    /** Initialize your data structure here. */
	    public SummaryRanges() {
	        set=new TreeSet<>(new Comparator<Interval>() {

				@Override
				public int compare(Interval o1, Interval o2) {
					return o1.start-o2.start;
				}
			});
	    }
	    
	    public void addNum(int val) {
	        Interval newInterval=new Interval(val, val);
	        Interval floor=set.floor(newInterval);
	        if (floor!=null) {
	        	if (floor.end+1==val) {
					newInterval.start=floor.start;
					set.remove(floor);
				}
				else if (floor.end>=val) {
					return;
				}
			}
	        Interval higher=set.higher(newInterval);
	        if (higher!=null) {
				if (val+1==higher.start) {
					newInterval.end=higher.end;
					set.remove(higher);
				}
			}
	        set.add(newInterval);
	    }
	    
	    public List<Interval> getIntervals() {
	        return new ArrayList<>(set);
	    }
	}

	/**
	 * Your SummaryRanges object will be instantiated and called as such:
	 * SummaryRanges obj = new SummaryRanges();
	 * obj.addNum(val);
	 * List<Interval> param_2 = obj.getIntervals();
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

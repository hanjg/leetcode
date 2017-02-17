package design;

import java.util.*;

public class FindMedianfromDataStream {
    PriorityQueue<Integer> larger = new PriorityQueue<>();
	PriorityQueue<Integer> smaller = new PriorityQueue<Integer>(1,Collections.reverseOrder());
    // Adds a number into the data structure.
    public void addNum(int num) {
    	larger.add(num);
    	smaller.add(larger.poll());
    	if(smaller.size()>larger.size())larger.add(smaller.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(smaller.size()==larger.size())return ((double)smaller.peek()+larger.peek())/2;
        else return larger.peek();
    }
}

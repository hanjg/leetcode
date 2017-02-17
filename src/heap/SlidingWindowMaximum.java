package heap;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	if (nums.length==0) {
			return new int[0];
		}
        Deque<Integer> deque=new ArrayDeque<>();//存储nums中元素的下标,队列中的下标按照对应元素从大到小排列
        int[] result=new int[nums.length-k+1];
        int r=0;
        for(int i=0;i<nums.length;i++){//插入i
        	while(!deque.isEmpty()&&deque.peek()<=i-k){//删除不在窗口中的下标
        		deque.poll();
        	}
        	while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){//删除比nums[i]小的下标
        		deque.pollLast();
        	}
        	deque.addLast(i);
        	if (i>=k-1) {
				result[r++]=nums[deque.peek()];
			}
        }
        return result;
    }

}

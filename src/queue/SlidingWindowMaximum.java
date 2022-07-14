package queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * problems-239 https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }
        //单调非递增队列，存储nums中元素的下标
        Deque<Integer> deque = new ArrayDeque<>(k);
        //滑动窗口总共n-k+1个位置
        int[] result = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            //加入窗口
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            //移出窗口
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            //计算窗口中的最大值
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new SlidingWindowMaximum().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}

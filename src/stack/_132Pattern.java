package stack;

import java.util.Stack;

public class _132Pattern {
	public boolean find132pattern(int[] nums) {
		// pattern2
		int mid = Integer.MIN_VALUE;
		// 存储pattern3的备用值，>pattern2,栈顶值最小
		Stack<Integer> stack = new Stack<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] < mid) {
				return true;
			} else if (nums[i] > mid) {
				while (!stack.isEmpty() && nums[i] > stack.peek()) {
					mid = stack.pop();
				}
				stack.push(nums[i]);
			}
		}
		return false;
	}

}

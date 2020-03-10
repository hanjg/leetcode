package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * problems-503 https://leetcode-cn.com/problems/next-greater-element-ii/
 */
public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % n];
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new NextGreaterElementII().nextGreaterElements(new int[]{1, 2, 1});
    }
}

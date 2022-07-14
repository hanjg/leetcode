package stack;

import java.util.Stack;

/**
 * problems-739 https://leetcode-cn.com/problems/daily-temperatures/
 */
public class DailyTemperatures {

    /**
     * 单调非递增栈存遍历元素的下界||寻找下一个较大元素
     */
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        //下标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int topIndex = stack.pop();
                res[topIndex] = i - topIndex;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        new DailyTemperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}

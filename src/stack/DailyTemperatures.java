package stack;

import java.util.Stack;

/**
 * problems-739 https://leetcode-cn.com/problems/daily-temperatures/
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        //单调递减栈存遍历元素的下界||寻找下一个较大元素
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        new DailyTemperatures().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
}

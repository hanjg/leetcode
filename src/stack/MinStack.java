package stack;


import java.util.Stack;

/**
 * problems-155 https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {

    private Stack<Integer> stack;
    /**
     * stack中minStack.peek之前的所有元素中的最小值
     */
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (minStack.peek().equals(stack.peek())) {
            //最小值出栈
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}

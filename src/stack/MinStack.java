package stack;


import java.util.Stack;

public class MinStack {
	Stack<Integer> stack;
	Stack<Integer> minStack;//存储stack中minStack.peek之前的所有元素中的最小值
    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()||x<=minStack.peek()) {//<=
			minStack.push(x);
		}
    }
    
    public void pop() {
        if (minStack.peek().equals(stack.peek())) {//用equals
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

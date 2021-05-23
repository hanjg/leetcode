package design;

import java.util.Stack;

/**
 * problems-232 https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class ImplementQueueusingStacks {

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        in.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        out.pop();
    }

    // Get the front element.
    public int peek() {
        //两个栈 -> 先进先出
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }


}

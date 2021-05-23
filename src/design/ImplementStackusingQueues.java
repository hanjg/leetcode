package design;

import java.util.*;

/**
 * problems-225 https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
public class ImplementStackusingQueues {

    Queue<Integer> queue = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        //最后加入的到队首，需要poll size-1次
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}

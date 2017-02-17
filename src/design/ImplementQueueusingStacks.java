package design;

import java.util.Stack;

public class ImplementQueueusingStacks {
	Stack<Integer> in=new Stack<>();
	Stack<Integer> out=new Stack<>();
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
        if(out.isEmpty())while(!in.isEmpty()) out.push(in.pop());
        return out.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return in.isEmpty()&&out.isEmpty();
    }


}

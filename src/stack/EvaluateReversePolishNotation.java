package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<tokens.length;i++){
        	String cur=tokens[i];
        	if(cur.equals("+")){
        		stack.push(stack.pop()+stack.pop());
        	}
        	else if(cur.equals("-")){
        		int b=stack.pop(),a=stack.pop();
        		stack.push(a-b);
        	}
        	else if (cur.equals("*")) {
				stack.push(stack.pop()*stack.pop());
			}
        	else if (cur.equals("/")) {
				int b=stack.pop(),a=stack.pop();
				stack.push(a/b);
			}else {
				stack.push(Integer.valueOf(cur));
			}
        }
        return stack.peek();
    }

}

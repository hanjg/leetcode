package stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();//stack中存储尚未配对的左括号
        char[] ca=s.toCharArray();
        for(int i=0;i<ca.length;i++){
        	if (ca[i]=='('||ca[i]=='['||ca[i]=='{') stack.push(ca[i]);
        	else if(stack.isEmpty())return false;
        	else if (ca[i]==')'&&stack.peek()=='(') stack.pop();
        	else if (ca[i]==')'&&stack.peek()!='(') return false;
        	else if (ca[i]==']'&&stack.peek()=='[') stack.pop();
        	else if (ca[i]==']'&&stack.peek()!='[') return false;
        	else if (ca[i]=='}'&&stack.peek()=='{') stack.pop();
        	else if (ca[i]=='}'&&stack.peek()!='{') return false;
        }
        return stack.isEmpty();
    }
    
    public boolean isValid2(String s){
    	Stack<Character> stack=new Stack<>();//stack中存储下一个期望到来的右括号
    	char[] ca=s.toCharArray();
    	for(int i=0;i<ca.length;i++){
    		if(ca[i]=='(')stack.push(')');
    		else if(ca[i]=='[')stack.push(']');
    		else if(ca[i]=='{')stack.push('}');
    		else if(stack.isEmpty()||ca[i]!=stack.pop())return false;
    	}
    	return stack.isEmpty();
    }

}

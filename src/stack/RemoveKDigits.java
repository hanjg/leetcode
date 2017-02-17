package stack;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
    	if(num.length()==0||k==0)return num;
        Stack<Character> stack=new Stack<>();stack.push((char)('0'-1));
        int i=0;
        while(i<num.length()){
        	while(k>0&&stack.peek()>num.charAt(i)){//>不可以>=
        		stack.pop();k--;
        	}
        	stack.push(num.charAt(i++));
        }
        StringBuilder builder=new StringBuilder();
        while(k>0){stack.pop();k--;}
        i=1;
        while(i<stack.size()&&stack.get(i)=='0')i++;
        while(i<stack.size())builder.append(stack.get(i++));
        return builder.length()==0?"0":builder.toString();
    }

}

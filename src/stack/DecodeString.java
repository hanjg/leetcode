package stack;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> result=new Stack<>();result.push("");
        Stack<Integer> count=new Stack<>();
        for(int i=0;i<s.length();i++){
        	char c=s.charAt(i);
        	if(Character.isDigit(c)){
        		int begin=i;
        		while(i+1<s.length()&&Character.isDigit(s.charAt(i+1)))i++;
        		count.push(Integer.valueOf(s.substring(begin, i+1)));
        	}
        	else if(c=='[')result.push("");
        	else if(c==']'){
        		String temp=result.pop();
        		int times=count.pop();
        		StringBuilder builder=new StringBuilder();
        		for(int j=0;j<times;j++) builder.append(temp);
        		result.push(result.pop()+builder.toString());
        	}
        	else result.push(result.pop()+c);
        }
        return result.peek();
    }
}

package stack;

import java.util.*;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack=new Stack<>();//目前为止最小的不重复字符串
        boolean[] exsit=new boolean[26];//存储stack中是否存在字符
        int[] fre=new int[26];//各个字符在当前位置之后出现的次数
        for(int i=0;i<s.length();i++){
        	fre[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
        	char c=s.charAt(i);fre[c-'a']--;
        	if(exsit[c-'a'])continue;
        	while(!stack.isEmpty()&&stack.peek()>c&&fre[stack.peek()-'a']>0)
        		exsit[stack.pop()-'a']=false;
        	stack.push(c);exsit[c-'a']=true;
        }
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<stack.size();i++){
        	builder.append(stack.get(i));
        }
        return builder.toString();
    }
}

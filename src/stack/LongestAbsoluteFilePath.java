package stack;

import java.util.Stack;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        String[] strings=input.split("\n");
        Stack<Integer> stack=new Stack<>();//存储该层目录的长度
        stack.push(0);//dummy
        int max=0;
        for(int i=0;i<strings.length;i++){
        	int level=strings[i].lastIndexOf("\t")+1;//有几个"\t"深度为几
        	while(stack.size()-1>level)stack.pop();
        	int len=strings[i].length()-level;
        	if(strings[i].contains(".")) max=Math.max(max,stack.peek()+len);
        	else stack.push(stack.peek()+len+1);
        }
        return max;
    }
}

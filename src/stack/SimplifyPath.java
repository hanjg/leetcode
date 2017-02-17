package stack;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
    	Stack<String> stack=new Stack<>();
    	String[] strings=path.split("/");
    	for(String string:strings){
    		switch (string) {
			case ".": break;//当前目录
			case "..": if(!stack.isEmpty())stack.pop();break;//父目录
			case "": break;
			default: stack.push(string);
			}
    	}
    	if(stack.isEmpty()) return "/";
    	StringBuilder builder=new StringBuilder();
		for(int i=0;i<stack.size();i++){
			builder.append("/");builder.append(stack.get(i));
		}
		return builder.toString();
    }
    public static void main(String[] args) {
		System.out.println(new SimplifyPath().simplifyPath("/a/./b/../../c/"));
	}
}

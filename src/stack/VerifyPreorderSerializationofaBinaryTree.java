package stack;

import java.util.Stack;

public class VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] elems=preorder.split(",");
        Stack<String> stack=new Stack<>();
        for(int i=0;i<elems.length;i++){
        	stack.push(elems[i]);
        	while(stack.size()>=3&&stack.get(stack.size()-1).equals("#")
        			&&stack.get(stack.size()-2).equals("#")&&!stack.get(stack.size()-3).equals("#")){//删除叶节点
        		stack.pop();stack.pop();stack.pop();
        		stack.push("#");
        	}
        }
        return stack.size()==1&&stack.peek().equals("#");
    }
    public boolean isValidSerialization2(String preorder) {
	    String[] elems=preorder.split(",");
	    int dif=1;//dir=out-in>=0
	    for(int i=0;i<elems.length;i++){
	    	if(--dif<0)return false;
	    	if(!elems[i].equals("#"))dif+=2;
	    }
	    return dif==0;
	}
	public static void main(String[] args) {
		System.out.println(new VerifyPreorderSerializationofaBinaryTree().isValidSerialization("#"));
	}
}

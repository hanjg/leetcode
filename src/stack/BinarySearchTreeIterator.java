package stack;

import java.util.*;

public class BinarySearchTreeIterator {
	Stack<TreeNode> stack;
	TreeNode cur;
	
    public BinarySearchTreeIterator(TreeNode root) {
        stack=new Stack<>();
        while(root!=null){stack.add(root);root=root.left;}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	if(stack.isEmpty())return false;
        cur=stack.pop();
        TreeNode temp=cur.right;
        while(temp!=null){
        	stack.add(temp);temp=temp.left;
        }
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        return cur.val;
    }
}

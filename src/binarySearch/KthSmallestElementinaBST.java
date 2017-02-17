package binarySearch;

import java.util.Stack;

public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode cur=root;
        Stack<TreeNode> stack=new Stack<>();
        while(cur!=null){
        	stack.push(cur);cur=cur.left;
        }
        while(!stack.isEmpty()){
        	cur=stack.pop();k--;
        	if(k==0)return cur.val;
        	if(cur.right!=null){
        		cur=cur.right;
        		while(cur!=null){
        			stack.push(cur);cur=cur.left;
        		}
        	}
        }
        return 0;
    }
}

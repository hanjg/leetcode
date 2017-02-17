package stack;
import java.util.*;
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> res=new ArrayList<>();
    	Stack<TreeNode> stack=new Stack<>();
    	TreeNode cur=root;
    	while(cur!=null){stack.push(cur);cur=cur.left;}
    	while(!stack.isEmpty()){
    		cur=stack.pop();
    		res.add(cur.val);
    		cur=cur.right;
    		while(cur!=null){stack.push(cur);cur=cur.left;}
    	}
    	return res;
    }
}

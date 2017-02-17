package stack;
import java.util.*;
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root!=null)stack.push(root);
        while(!stack.isEmpty()){
        	TreeNode cur=stack.pop();
        	res.add(cur.val);
        	if(cur.right!=null)stack.add(cur.right);
        	if(cur.left!=null)stack.add(cur.left);
        }
        return res;
    }
}

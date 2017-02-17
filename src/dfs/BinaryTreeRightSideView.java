package dfs;
import java.util.*;
public class BinaryTreeRightSideView {
	List<Integer> list;
    public List<Integer> rightSideView(TreeNode root) {
        list=new ArrayList<>();
        if (root!=null) {
			dfs(0, root);
		}
        return list;
    }
    
    private void dfs(int depth,TreeNode node){
    	if(depth==list.size()) list.add(node.val);
    	if (node.right!=null) {
			dfs(depth+1, node.right);
		}
    	if (node.left!=null) {
			dfs(depth+1, node.left);
		}
    	
    }

}

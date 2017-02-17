package dfs;
import java.util.*;

public class BinaryTreePaths {
	List<String> result;
    public List<String> binaryTreePaths(TreeNode root) {
        result=new ArrayList<>();
        if(root==null)return result;
        dfs(root, "");
        return result;
    }
    
    private void dfs(TreeNode node,String string){
    	if (node.left==null&&node.right==null) {
			result.add(string+node.val);
		}
    	if (node.left!=null) {
			dfs(node.left, string+node.val+"->");
		}
    	if (node.right!=null) {
			dfs(node.right, string+node.val+"->");
		}
    }
}

package dfs;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
    	return dfs(root,null,null);
    }
    
    private boolean dfs(TreeNode node,TreeNode min,TreeNode max){
    	if(node==null)return true;
    	if((min!=null&&node.val<=min.val)||(max!=null&&node.val>=max.val))return false;
    	return dfs(node.left, min, node)&&dfs(node.right, node, max);
    }
}

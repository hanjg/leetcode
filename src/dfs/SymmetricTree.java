package dfs;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode a,TreeNode b){
    	if(a==null&&b==null)return true;
    	if(a==null||b==null||a.val!=b.val)return false;
    	return isMirror(a.left, b.right)&&isMirror(a.right, b.left);
    }
}

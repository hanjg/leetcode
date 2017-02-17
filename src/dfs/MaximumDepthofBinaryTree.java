package dfs;

public class MaximumDepthofBinaryTree {
    public int maxDepth2(TreeNode root) {
        if(root==null)return 0;
        return dfs(root,1);
    }
    private int dfs(TreeNode node,int level){//以node为根节点的最大深度
    	if (node.left==null&&node.right==null) {
			return level;
		}
    	int left=level,right=level;
    	if(node.left!=null)left=dfs(node.left, level+1);
    	if(node.right!=null)right=dfs(node.right, level+1);
    	return Math.max(left, right);
    }
	public int maxDepth(TreeNode root) {
	    if(root==null)return 0;
	    return Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
	}
}

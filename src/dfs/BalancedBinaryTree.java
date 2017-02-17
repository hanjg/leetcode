package dfs;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
    	return depth(root)!=-1;
    }
    
    private int depth(TreeNode node){//如果左右子树平衡返回节点的深度，不平衡返回-1
    	if(node==null)return 0;
    	
    	int LH=depth(node.left);
    	if(LH==-1)return -1;
    	int RH=depth(node.right);
    	if(RH==-1)return -1;
    	if(Math.abs(LH-RH)>1) return -1;
    	
    	return Math.max(LH, RH)+1;
    	
    }
}

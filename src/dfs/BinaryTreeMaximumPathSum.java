package dfs;

public class BinaryTreeMaximumPathSum {
	int max=Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		if (root==null) {
			return 0;
		}
		return Math.max(dfs(root), max);
    }
    
    private int dfs(TreeNode node){
		//返回以node诶根节点开始到叶节点的最大路径,不可从node的叶节点到叶节点
		if (node.left==null&&node.right==null) {
		    return node.val;
		}
		int left=0,right=0;
		if (node.left!=null) {
			left=dfs(node.left);
			max=Math.max(max, left);
			left=Math.max(0, left);
		}
		if (node.right!=null) {
			right=dfs(node.right);
			max=Math.max(max,right);
			right=Math.max(0, right);	
		}
		max=Math.max(max, node.val+left+right);
		return node.val+Math.max(left, right);
	}

	@SuppressWarnings("unused")
	private void dfs(TreeNode node,int[] parentSum,int lr){
    	//parentSum node双亲节点第左或右子树到叶节点过程中路径和的最大值,lr==0是双亲节点的左节点，lr==1是双亲的右节点
    	int[] lrSum=new int[2];lrSum[0]=lrSum[1]=node.val;
    	
    	if (node.left!=null) {
			dfs(node.left, lrSum, 0);
			max=Math.max(max, lrSum[0]);
		}
    	if (node.right!=null) {
			dfs(node.right, lrSum, 1);
			max=Math.max(max, lrSum[1]);
		}
    	max=Math.max(max, lrSum[0]+lrSum[1]-node.val);
    	if(Math.max(lrSum[0], lrSum[1])>0) parentSum[lr]+=Math.max(lrSum[0], lrSum[1]);
    }
}

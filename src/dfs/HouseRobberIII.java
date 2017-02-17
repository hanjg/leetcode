package dfs;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] t=dfs(root);
        return Math.max(t[0], t[1]);
    }

    private int[]dfs(TreeNode node){//返回不抢和抢node的钱最大值
    	if(node==null)return new int[2];
    	int[] left=dfs(node.left);
    	int[] right=dfs(node.right);
    	int[] cur=new int[2];
    	cur[0]=Math.max(left[0], left[1])+Math.max(right[0], right[1]);//不抢node
    	cur[1]=left[0]+ right[0]+node.val;//抢node
    	return cur;
    }
}

package dfs;
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
    	if(root==null)return 0;
    	System.out.println(root.val+" "+sum);
    	if(root.left==null&&root.right==null&&sum==root.val)return 1;
    	return pathSum(root.left, sum-root.val)+pathSum(root.right, sum-root.val);
    }
}

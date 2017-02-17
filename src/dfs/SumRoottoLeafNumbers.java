package dfs;

public class SumRoottoLeafNumbers {
	int sum=0;
    public int sumNumbers(TreeNode root) {
        if (root!=null) {
			dfs(root, 0);
		}
        return sum;
    }
    
    private void dfs(TreeNode node,int pre){
    	if (node.left==null&&node.right==null) {
			sum+=10*pre+node.val;return;
		}
    	if (node.left!=null) {
			dfs(node.left, 10*pre+node.val);
		}
    	if (node.right!=null) {
			dfs(node.right, 10*pre+node.val);
		}
    }
}

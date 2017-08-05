package dfs;

public class ConvertBSTtoGreaterTree {
	private int sum = 0;

	public TreeNode convertBST(TreeNode root) {
		dfs(root);
		return root;
	}

	private void dfs(TreeNode node) {
		if (node == null) {
			return;
		}
		dfs(node.right);
		node.val += sum;
		sum = node.val;
		dfs(node.left);
	}

}

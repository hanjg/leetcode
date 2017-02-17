package dfs;

public class FlattenBinaryTreetoLinkedList {
	TreeNode head=null;
    public void flatten(TreeNode root) {
    	if(root==null)return;
    	flatten(root.right);
    	flatten(root.left);
    	root.right=head;
    	root.left=null;
    	head=root;
    }
}

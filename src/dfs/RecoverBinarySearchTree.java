package dfs;

public class RecoverBinarySearchTree {
	TreeNode misTake1,misTake2,pre=new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inOrder(root);//中序遍历:中序遍历正确的BST得到的结果递增
        int temp=misTake1.val;
        misTake1.val=misTake2.val;
        misTake2.val=temp;
    }
    private void inOrder(TreeNode node){
    	if(node==null)return;
    	inOrder(node.left);
    	if(node.val<pre.val){
    		if(misTake1==null){misTake1=pre;misTake2=node;}
    		else misTake2=node;
    	}
    	pre=node;
    	inOrder(node.right);
    }
}

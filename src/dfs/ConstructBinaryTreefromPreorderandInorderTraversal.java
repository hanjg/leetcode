package dfs;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	int preHead=0;//head在preorder中的下标
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(0, inorder.length-1, preorder, inorder);
    }
    private TreeNode dfs(int begin,int end,int[] preorder,int[]inorder){
    	//preorder中preHead为根节点在inOrder中的范围[begin,end]建树，返回根节点
    	if(begin>end)return null;
    	TreeNode root=new TreeNode(preorder[preHead++]);
    	int inHead=begin;//head在inorder中的下标
    	for(int i=begin+1;i<=end;i++)
    		if(inorder[i]==root.val){
    			inHead=i;break;
    		}
    	root.left=dfs(begin, inHead-1, preorder, inorder);
    	root.right=dfs(inHead+1, end, preorder, inorder);
    	return root;
    }
}

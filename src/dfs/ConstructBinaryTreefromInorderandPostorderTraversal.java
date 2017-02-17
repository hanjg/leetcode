package dfs;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	int postRoot;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postRoot=postorder.length-1;
        return dfs(0, inorder.length-1, inorder, postorder);
    }
    private TreeNode dfs(int begin,int end,int[]inorder,int[]postorder){
    	if(begin>end)return null;
    	TreeNode root=new TreeNode(postorder[postRoot--]);
    	int inRoot=0;//root在inorder中的下标
    	for(int i=begin;i<=end;i++){
    		if(inorder[i]==root.val){inRoot=i;break;}
    	}
    	root.right=dfs(inRoot+1, end, inorder, postorder);
    	root.left=dfs(begin, inRoot-1, inorder, postorder);
    	return root;
    }
}

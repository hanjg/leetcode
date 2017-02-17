package dfs;

public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null)return null;
        return dfs(0,nums.length-1,nums);
    }
    private TreeNode dfs(int left,int right,int[] nums){//在[left,right]构造BST返回根节点
    	if(left>right)return null;
    	int mid=(left+right)/2;
    	TreeNode root=new TreeNode(nums[mid]);
    	root.left=dfs(left, mid-1, nums);
    	root.right=dfs(mid+1, right, nums);
    	return root;
    }
}

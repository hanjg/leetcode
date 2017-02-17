package binarySearch;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int dep=depth(root);
        if(dep==-1)return 0;
        else if(depth(root.right)==dep-1){//最后一个节点在root的右子树
        	return (1<<dep)+countNodes(root.right);
        }else {
			return (1<<dep-1)+countNodes(root.left);//+-*/的优先级高于<<h
		}
    }
    private int depth(TreeNode node){//以node为根节点的树的深度
    	return node==null?-1:(depth(node.left)+1);
    }
    public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		System.out.println(new CountCompleteTreeNodes().countNodes(root));
	}
}

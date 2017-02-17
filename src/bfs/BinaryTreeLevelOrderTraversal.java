package bfs;

import java.util.*;
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null) return res;
        queue.add(root);
        while(!queue.isEmpty()){
        	int	num=queue.size();//该层的节点个数
        	List<Integer> level=new ArrayList<>();
        	for(int i=0;i<num;i++){
        		TreeNode temp=queue.poll();
        		level.add(temp.val);
        		if(temp.left!=null)queue.add(temp.left);
        		if(temp.right!=null)queue.add(temp.right);
        	}
        	res.add(level);
        }
        return res;
    }

}

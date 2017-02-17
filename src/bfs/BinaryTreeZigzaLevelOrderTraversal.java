package bfs;
import java.util.*;
public class BinaryTreeZigzaLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null)return res;
        queue.add(root);
        boolean lToR=true;
        while(!queue.isEmpty()){
        	int num=queue.size();
        	List<Integer> level=new LinkedList<>();
        	for(int i=0;i<num;i++){
        		TreeNode temp=queue.poll();
        		level.add(lToR?level.size():0, temp.val);
        		if(temp.left!=null)queue.add(temp.left);
        		if(temp.right!=null)queue.add(temp.right);
        	}
        	res.add(level);
        	lToR=!lToR;
        }
        return res;
    }

}

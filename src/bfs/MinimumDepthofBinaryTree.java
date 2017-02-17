package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int level=1;//队列中节点的深度
        while(!queue.isEmpty()){
        	int num=queue.size();
        	for(int i=0;i<num;i++){
        		TreeNode temp=queue.poll();
        		if(temp.left==null&&temp.right==null) return level;
        		if(temp.left!=null)queue.add(temp.left);
        		if(temp.right!=null)queue.add(temp.right);
        	}
        	level++;
        }
        return -1;
    }
	
}

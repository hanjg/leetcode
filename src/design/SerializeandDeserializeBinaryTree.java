package design;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class SerializeandDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "null";
    	StringBuilder builder=new StringBuilder(String.valueOf(root.val));
    	builder.append(",");
    	builder.append(serialize(root.left));
    	builder.append(",");
    	builder.append(serialize(root.right));
    	return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String>queue=new LinkedList<>();
        String[]strings=data.split(",");
        for(String string:strings) queue.add(string);
        return preOrder(queue);
    }
    private TreeNode preOrder(Queue<String>queue){//返回前序遍历的根节点
    	String cur=queue.poll();
    	if(cur.equals("null"))return null;
    	TreeNode root=new TreeNode(Integer.valueOf(cur));
    	root.left=preOrder(queue);
    	root.right=preOrder(queue);
    	return root;
    }
    public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		System.out.println(new SerializeandDeserializeBinaryTree().serialize(root));
	}
}

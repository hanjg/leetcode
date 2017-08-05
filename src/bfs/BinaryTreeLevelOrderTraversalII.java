package bfs;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null)
			return res;
		queue.add(root);
		while (!queue.isEmpty()) {
			int num = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < num; i++) {
				TreeNode temp = queue.poll();
				list.add(temp.val);
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
			res.add(0, list);
		}
		return res;
	}

	List<List<Integer>> res;

	public List<List<Integer>> levelOrder(TreeNode root) {
		res = new LinkedList<>();
		addLevel(0, root);
		return res;
	}

	private void addLevel(int level, TreeNode node) {
		if (node == null)
			return;
		if (level >= res.size())
			res.add(0, new LinkedList<Integer>());// level<res.size
		res.get(res.size() - 1 - level).add(node.val);
		addLevel(level + 1, node.left);
		addLevel(level + 1, node.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		System.out.println(new BinaryTreeLevelOrderTraversalII().levelOrder(root));
	}
}

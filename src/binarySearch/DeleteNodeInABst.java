package binarySearch;

/**
 * @author hanjigang
 * @date 2026/6/8 20:33
 */
public class DeleteNodeInABst {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // 找到right的最左边的叶子节点，left设置为叶子的left
                TreeNode target = root.right;
                while (target.left != null) {
                    target = target.left;
                }
                target.left = root.left;
                return root.right;
            }
        }
    }
}

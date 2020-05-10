package binarySearch;

/**
 * problems-236 https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestorofaBinaryTree {

    /**
     * 后续遍历寻找p,q
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        //pq在左子节点先祖
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //pq在右子节点先祖
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
    }
}

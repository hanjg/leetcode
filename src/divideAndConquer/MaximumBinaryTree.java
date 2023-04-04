package divideAndConquer;

/**
 * problems-654 https://leetcode.cn/problems/maximum-binary-tree/
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode() {
    }
}

public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] > maxValue) {
                maxIndex = i;
                maxValue = nums[i];
            }
        }
        TreeNode left = build(nums, start, maxIndex - 1);
        TreeNode right = build(nums, maxIndex + 1, end);
        TreeNode node = new TreeNode();
        node.val = nums[maxIndex];
        node.right = right;
        node.left = left;
        return node;
    }
}

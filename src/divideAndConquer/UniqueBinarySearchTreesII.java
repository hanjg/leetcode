package divideAndConquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * problems-95 https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBinarySearchTreesII {

    private Map<Integer, List<TreeNode>> nodeCache = new HashMap<>();

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<TreeNode> res0 = new ArrayList<>();
        res0.add(null);
        nodeCache.put(0, res0);
        List<TreeNode> res1 = new ArrayList<>();
        res1.add(new TreeNode(1));
        nodeCache.put(1, res1);
        return create(1, n);
    }

    /**
     * 创建数值[begin,end]的节点
     */
    private List<TreeNode> create(int begin, int end) {
        int len = end - begin + 1;
        len = len < 0 ? 0 : len;
        List<TreeNode> cached = nodeCache.get(len);
        if (cached != null) {
            return clone(cached, begin - 1);
        }
        List<TreeNode> res = new ArrayList<>();
        for (int root = begin; root <= end; root++) {
            List<TreeNode> left = create(begin, root - 1);
            List<TreeNode> right = create(root + 1, end);
            for (TreeNode leafNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode node = new TreeNode(root);
                    node.left = leafNode;
                    node.right = rightNode;
                    res.add(node);
                }
            }
        }
        if (begin == 1) {
            nodeCache.put(len, res);
        }
        return res;
    }

    private List<TreeNode> clone(List<TreeNode> root, int offset) {
        if (offset == 0) {
            return root;
        }
        List<TreeNode> list = new ArrayList<>();
        for (TreeNode node : root) {
            list.add(clone(node, offset));
        }
        return list;
    }

    private TreeNode clone(TreeNode root, int offset) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val + offset);
        newRoot.left = clone(root.left, offset);
        newRoot.right = clone(root.right, offset);
        return newRoot;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTreesII().generateTrees(3));
    }

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


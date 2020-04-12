package dp;


/**
 * problems-337 https://leetcode-cn.com/problems/house-robber-iii/
 */
public class HouseRobberIII {

    public int rob(TreeNode root) {
        int[] t = dfs(root);
        return Math.max(t[0], t[1]);
    }

    /**
     * @return dp[0]：不抢node的最大值；dp[1]：抢node的最大值
     */
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int[] res = new int[2];
        //不抢node，子节点可抢可不抢
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //抢node，子节点不可抢
        res[1] = node.val + left[0] + right[0];
        return res;
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

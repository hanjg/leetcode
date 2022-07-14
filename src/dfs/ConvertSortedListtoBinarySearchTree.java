package dfs;


/**
 * problems-109 https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertSortedListtoBinarySearchTree {

    private ListNode cur;

    public TreeNode sortedListToBST(ListNode head) {
        cur = head;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return dfs(0, len - 1);
    }

    private TreeNode dfs(int begin, int end) {
        if (begin > end) {
            return null;
        }
        int mid = begin + (end - begin) / 2;
        TreeNode left = dfs(begin, mid - 1);
        //中序遍历的顺序同链表顺序
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = dfs(mid + 1, end);

        root.left = left;
        root.right = right;
        return root;
    }

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

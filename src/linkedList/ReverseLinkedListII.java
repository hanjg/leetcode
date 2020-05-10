package linkedList;

/**
 * problems-92 https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode virtualNode = new ListNode(0);
        virtualNode.next = head;
        //从list[0]开始寻找前一段尾节点list[m-1]
        ListNode preTail = virtualNode;
        for (int i = 0; i < m - 1; i++) {
            preTail = preTail.next;
        }
        //从list[m]开始寻找目标段尾节点list[n]
        ListNode end = preTail.next;
        for (int i = m; i < n; i++) {
            end = end.next;
        }
        reverse(preTail, end);
        return virtualNode.next;
    }

    /**
     * @param preTail 目标段的前一段尾节点
     * @param end 目标段尾节点
     */
    private void reverse(ListNode preTail, ListNode end) {
        ListNode cur = preTail.next;
        ListNode pre = preTail;
        ListNode next = null;
        while (pre != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //cur为目标段后一段头结点
        preTail.next.next = cur;
        //pre为目标段新的头结点
        preTail.next = pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        new ReverseLinkedListII().reverseBetween(node1, 2, 4);
    }

}

package linkedList;

/**
 * problems-25 https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesinkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode virtualNode = new ListNode(0);
        virtualNode.next = head;
        //需要翻转的链表段之前的尾节点
        ListNode preTail = virtualNode;
        while (preTail.next != null) {
            ListNode nextTail = preTail.next;
            ListNode end = preTail;
            //寻找目标段尾节点
            for (int i = 0; end != null && i < k; i++) {
                end = end.next;
            }
            if (end == null) {
                //剩余节点[pretail.next, end] 总数<k个，不翻转
                break;
            }
            reverse(preTail, end);
            preTail = nextTail;
        }
        return virtualNode.next;
    }

    /**
     * @param tail 目标段的前一段尾节点
     * @param end 目标段尾节点
     */
    private void reverse(ListNode tail, ListNode end) {
        ListNode cur = tail.next;
        ListNode pre = tail;
        ListNode next = null;
        while (pre != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //cur为目标段后一段头结点
        tail.next.next = cur;
        //pre为目标段新的头结点
        tail.next = pre;
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
        new ReverseNodesinkGroup().reverseKGroup(node1, 2);
    }
}

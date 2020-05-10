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
            ListNode end = preTail.next;
            //寻找目标段尾节点
            for (int i = 1; end != null && i < k; i++) {
                end = end.next;
            }
            if (end == null) {
                //剩余节点<k个，不翻转
                break;
            }
            ListNode tail = preTail.next;
            reverse(preTail, end);
            preTail = tail;
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
}

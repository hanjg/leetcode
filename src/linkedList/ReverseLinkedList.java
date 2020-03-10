package linkedList;

/**
 * problems-206 https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}

package linkedList;

/**
 * problems-206 https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //pre为新链表头
        return pre;
    }

}

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
            //找到下一轮的节点
            next = cur.next;
            //翻转
            cur.next = pre;
            //进入下一轮
            pre = cur;
            cur = next;
        }
        //pre为新链表头
        return pre;
    }

}

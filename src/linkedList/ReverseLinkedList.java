package linkedList;

/**
 * problems-206 https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {// 等价于pre停留在老列表末尾节点
            //预占下一轮节点
            next = cur.next;
            //实现翻转
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        //新链表头
        return pre;
    }

}

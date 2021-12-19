package twoPointer;

/**
 * problems-142 https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            //快慢指针找环
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                //有环，将fast=head,并和slow以相同的速度向前，相等时即为环的起点
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }


}

package twoPointer;


/**
 * problems-160 https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            //其中一个是null，代表他遍历完一个链表，需要开始遍历第二个
            if (p1 == null) {
                p1 = headB;
                p2 = p2.next;
            } else if (p2 == null) {
                p2 = headA;
                p1 = p1.next;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return p1;
    }


}

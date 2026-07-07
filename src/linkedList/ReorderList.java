package linkedList;


/**
 * problems-2266 https://leetcode.cn/problems/reorder-list/description/
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        // 快慢指针找到中点
        ListNode mid = getMid(head);

        // 截断链表
        ListNode first = head;
        ListNode second = mid.next;
        mid.next = null;

        // 反转后半段
        second = reverse(second);
        // merge链表
        merge(first, second);
    }

    private void merge(ListNode first, ListNode second) {
        while (first != null && second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }

    private ListNode getMid(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode node) {
        ListNode cur = node;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 新的首节点
        return pre;
    }

    public static void main(String[] args) {
        int[] num = {5, 4, 3, 2, 1};
        ListNode head = new ListNode(5);
        for (int i = 1; i < 5; i++) {
            ListNode temp = new ListNode(num[i]);
            temp.next = head;
            head = temp;
        }
        new ReorderList().reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

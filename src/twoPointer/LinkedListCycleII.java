package twoPointer;

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
    	if (head==null) {
			return null;
		}
        ListNode fast=head,slow=head;
        while(fast.next!=null&&fast.next.next!=null){
        	fast=fast.next.next;
        	slow=slow.next;
        	if (fast==slow) {//有环，将fast==head,并和slow以相同的速度向前，相等时即为环的起点
				fast=head;
				while(fast!=slow){
					fast=fast.next;
					slow=slow.next;
				}
				return fast;
			}
        }
        return null;
    }
	
	

}

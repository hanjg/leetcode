package sort;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead=new ListNode(0),pre;
        while(head!=null){
        	pre=newHead;
        	while(pre.next!=null&&pre.next.val<head.val) pre=pre.next;
        	if (pre.next==null) {
				pre=pre.next=head;
				head=head.next;
				pre.next=null;
			}
        	else {
				ListNode temp=head;
				head=head.next;
				temp.next=pre.next;
				pre.next=temp;
			}
        }
        return newHead.next;
    }

}

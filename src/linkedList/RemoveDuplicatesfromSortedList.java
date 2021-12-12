package linkedList;


public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
    	if(head==null||head.next==null) return head;
    	for(ListNode cur=head;cur!=null&&cur.next!=null;cur=cur.next){
    		while(cur.next!=null&&cur.val==cur.next.val) cur.next=cur.next.next;
    	}
    	return head;
    }
}

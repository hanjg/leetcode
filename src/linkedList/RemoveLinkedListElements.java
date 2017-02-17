package linkedList;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dum=new ListNode(0);dum.next=head;
        ListNode cur=dum;
        while(cur.next!=null){
        	if (cur.next.val==val) {
				cur.next=cur.next.next;
			}else {
				cur=cur.next;
			}
        }
        return dum.next;
    }

}

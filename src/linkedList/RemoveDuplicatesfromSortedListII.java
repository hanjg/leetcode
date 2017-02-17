package linkedList;

public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
    	if(head==null||head.next==null)	return head;
    	ListNode dum=new ListNode(0);dum.next=head;
    	ListNode pre=dum;
    	for(ListNode cur=head;cur!=null;cur=cur.next){
    		while(cur.next!=null&&cur.next.val==cur.val) cur=cur.next;//[pre.next,cur]重复
    		if(pre.next==cur) pre=cur;
    		else pre.next=cur.next;
    	}
    	return dum.next;
    }
}

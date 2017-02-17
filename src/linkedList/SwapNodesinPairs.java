package linkedList;

public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
    	if(head==null||head.next==null)return head;
    	ListNode dum=new ListNode(0);dum.next=head;
    	ListNode tail=dum;
    	while(tail.next!=null&&tail.next.next!=null){
    		ListNode p1=tail.next,p2=p1.next,temp=p2.next;
    		p1.next=temp;p2.next=p1;tail.next=p2;
    		tail=p1;
    	}
    	return dum.next;
    }

}

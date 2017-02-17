package twoPointer;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode dum=new ListNode(0);dum.next=head;
    	ListNode fast=dum,slow=dum;
    	for(int i=0;i<=n;i++)fast=fast.next;
    	//fast和slow之间gap为n+1,当fast为末尾的null时，slow指向倒数第n+1个结点
    	while(fast!=null){
    		slow=slow.next;fast=fast.next;
    	}
    	slow.next=slow.next.next;
    	return dum.next;
    }

}

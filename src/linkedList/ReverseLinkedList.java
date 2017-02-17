package linkedList;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode p1=head,p2=head.next;
        while(p2!=null){
        	ListNode temp=p2.next;
        	p2.next=p1;
        	p1=p2;p2=temp;
        }
        head.next=null;
        return p1;
    }

}

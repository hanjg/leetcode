package linkedList;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode oddtail=head,evenhead=head.next,eventail=head.next;
        while(eventail!=null&&eventail.next!=null){
        	oddtail=oddtail.next=eventail.next;
        	eventail=eventail.next=oddtail.next;
        	oddtail.next=evenhead;
        }
        return head;
    }
}

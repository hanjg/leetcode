package linkedList;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)return true;
        ListNode slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
        	slow=slow.next;fast=fast.next.next;
        }
        ListNode head2=slow.next;
        slow.next=null;
        ListNode p1=head2,p2=head2.next;
        while(p2!=null){
        	ListNode temp=p2.next;
        	p2.next=p1;
        	p1=p2;p2=temp;
        }
        head2.next=null;head2=p1;
        while(head2!=null){
        	if(head.val!=head2.val)return false;
        	head=head.next;head2=head2.next;
        }
        return true;
    }

}

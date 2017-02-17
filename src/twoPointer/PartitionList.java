package twoPointer;


class ListNode {
	int val;
	ListNode next;
 	ListNode(int x) { val = x; }
 }

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode sDum=new ListNode(0);
        ListNode sTail=sDum;//小于x链表的尾结点
        ListNode lDum=new ListNode(0);
        ListNode lTail=lDum;//大于x链表的尾结点
        for(ListNode cur=head;cur!=null;cur=cur.next){
        	if (cur.val<x) {
				sTail=sTail.next=cur;
			}
        	else {
				lTail=lTail.next=cur;
			}
        }
        sTail.next=lDum.next;
        lTail.next=null;
        return sDum.next;
    }
    public static void print(ListNode head){
    	while(head!=null){
    		System.out.print(head.val+".");
    		head=head.next;
    	}
    	System.out.println();
    }
    public static void main(String[] args) {
    	ListNode head=new ListNode(2);head.next=new ListNode(1);
    	print(head);
    	ListNode newHead=new PartitionList().partition(head,2);
    	print(newHead);
	}
}

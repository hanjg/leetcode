package linkedList;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if(head==null)return null;
        ListNode addition=new ListNode(0);addition.next=head;
        ListNode pre=addition;
        for(int i=0;i<m-1;i++)pre=pre.next;//pre为前一段的尾结点
        
        ListNode p1=pre.next,p2=p1.next;
        for(int i=m;i<n;i++){//p1为于第i个结点
        	ListNode temp=p2.next;
        	p2.next=p1;p1=p2;p2=temp;
        }//最后p2为后一段的头结点
        pre.next.next=p2;
        pre.next=p1;
        return addition.next;
    }

}

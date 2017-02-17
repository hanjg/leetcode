package linkedList;


public class ReorderList {
    public void reorderList(ListNode head) {
    	if(head==null||head.next==null)return ;
        ListNode slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
        	slow=slow.next;
        	fast=fast.next.next;
        }//结束时以slow为尾节点的链表数量等于或多一个其后的节点数量
        ListNode head2=slow.next;
        slow.next=null;
        head2=reverse(head2);
        ListNode newhead=new ListNode(0);
        ListNode cur=newhead;
        while(head2!=null){
        	cur=cur.next=head;head=head.next;
        	cur=cur.next=head2;head2=head2.next;
        }
        if(head!=null)cur.next=head;
        head=newhead.next;
    }
    private ListNode reverse(ListNode head){
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
    public static void main(String[]args){
    	int[]num={3,2,1};
    	ListNode head=new ListNode(3);
    	for(int i=1;i<3;i++){
    		ListNode temp=new ListNode(num[i]);
    		temp.next=head;head=temp;
    	}
    	new ReorderList().reorderList(head);
    }
}

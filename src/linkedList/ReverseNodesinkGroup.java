package linkedList;

public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
    	if(head==null||head.next==null||k==1)return head;
    	ListNode dum=new ListNode(0);dum.next=head;
    	ListNode tail=dum;
    	while(tail.next!=null){
    		ListNode end=tail.next;int count=1;//count表示tail之后到end总共有count个结点
    		while(end!=null&&count<k){
    			end=end.next;count++;
    		}
    		if(end!=null){
    			ListNode temp=tail.next;
    			reverse(tail, end);
    			tail=temp;
    		}
    		else break;
    	}
    	return dum.next;
    }
    
    private void reverse(ListNode pre,ListNode end){
    	ListNode p1=pre.next,p2=p1.next;
    	while(p1!=end){
    		ListNode temp=p2.next;
    		p2.next=p1;p1=p2;p2=temp;
    	}
    	pre.next.next=p2;pre.next=p1;//pre.next.next=p2不是end.next
    }
}

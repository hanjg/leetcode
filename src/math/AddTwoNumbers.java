package math;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode dum=new ListNode(0),tail=dum;
    	int carry=0;//进位
    	while(l1!=null||l2!=null){
    		int sum=carry;
    		if(l1!=null){sum+=l1.val;l1=l1.next;}
    		if(l2!=null){sum+=l2.val;l2=l2.next;}
    		tail=tail.next=new ListNode(sum%10);
    		carry=sum/10;
    	}
    	if(carry==1) tail=tail.next=new ListNode(carry);
    	return dum.next;
    }

}

package twoPointer;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
    	if(head==null||head.next==null||k==0)return head;
    	int len=1;ListNode tail=head;
    	while(tail.next!=null){
    		tail=tail.next;len++;
    	}
    	tail.next=head;//tail和head拼接成环,寻找新的链表尾
    	k=k%len;
    	for(int i=0;i<len-k;i++) tail=tail.next;
    	head=tail.next;tail.next=null;
    	return head;
    }

}

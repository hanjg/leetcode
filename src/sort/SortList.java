package sort;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}

public class SortList {
	public ListNode sortList(ListNode head) {//递归使用归并算法nlbn
    	if (head==null||head.next==null) {
			return head;
		}
    	ListNode slow=head,fast=head,pre=null;
    	while(fast!=null&&fast.next!=null){//将链表分为两段，head和slow为头
    		pre=slow;
    		fast=fast.next.next;
    		slow=slow.next;
    	}
    	pre.next=null;
    	ListNode head1=sortList(head);
    	ListNode head2=sortList(slow);
    	return merge(head1, head2);
    }
    
    private ListNode merge(ListNode head1,ListNode head2){//将head2为头的链表归并到head1为头的链表上
    	ListNode newhead=null,pre=null;//在pre之后插入节点
    	while(head1!=null&&head2!=null){
    		if (head2.val<head1.val) {
				if (newhead==null) {
					newhead=head2;
					pre=head2;
					head2=head2.next;
					
				}
				else {
					pre.next=head2;
					pre=head2;
					head2=head2.next;
				}
			}
    		else {
    			if (newhead==null) {
					newhead=head1;
					pre=head1;
					head1=head1.next;
				}
    			else {
					pre.next=head1;
					pre=head1;
					head1=head1.next;
				}
			}
    	}
    	//print(newhead);print(head2);System.out.println();
    	if (head1!=null) {
			pre.next=head1;
		}
    	if(head2!=null){
    		pre.next=head2;
    	}
    	return newhead;
    }
    
    private static void print(ListNode head){
    	System.out.print("head=");
    	while(head!=null){
    		System.out.print(head.val+" ");
    		head=head.next;
    	}
    }
	public static void main(String[] args) {
		SortList sortList=new SortList();
		ListNode head=null;
		int[] nums={3,2,4};
		for(int i=0;i<nums.length;i++){
			ListNode temp=new ListNode(nums[i]);
			temp.next=head;
			head=temp;
		}
		print(sortList.sortList(head));;
		
	}

}

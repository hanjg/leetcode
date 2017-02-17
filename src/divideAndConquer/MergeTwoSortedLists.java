package divideAndConquer;


public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1==null)return l2;
    	if(l2==null)return l1;
    	ListNode dum=new ListNode(0),tail=dum;//建立辅助接点dum
    	while(l1!=null&&l2!=null){
    		if (l1.val<l2.val) {
				tail=tail.next=l1;
				l1=l1.next;
			}
    		else {
				tail=tail.next=l2;
				l2=l2.next;
			}
    	}
    	if(l1!=null)tail.next=l1;
    	else tail.next=l2;
    	return dum.next;
    }

	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if(l1==null)return l2;
		if(l2==null)return l1;
		ListNode head=null,tail=null;
		while(l1!=null&&l2!=null){
			if(l1.val<l2.val){
				if(tail==null){
					head=l1;tail=l1;
				}
				else {
					tail=tail.next=l1;
				}
				l1=l1.next;
			}
			else {
				if (tail==null) {
					head=l2;tail=l2;
				}
				else {
					tail=tail.next=l2;
				}
				l2=l2.next;
			}
		}
		if(l1!=null)tail.next=l1;
		else tail.next=l2;
		return head;
	}
}

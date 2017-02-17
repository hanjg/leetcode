package linkedList;

public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null) {
			return null;
		}
        ListNode pa=headA,pb=headB;
        int lenA=len(headA),lenB=len(headB);
        while(lenA>lenB){
        	pa=pa.next;lenA--;//lenA表示从pa到末尾的长度
        }
        while(lenA<lenB){
        	pb=pb.next;lenB--;
        }
        while(pa!=null){
        	if (pa==pb) {
				return pa;
			}
        	pa=pa.next;pb=pb.next;
        }
        return null;
    }
    
    private int len(ListNode head){//
    	int length=0;
    	while(head!=null){
    		head=head.next;length++;
    	}
    	return length;
    }

}

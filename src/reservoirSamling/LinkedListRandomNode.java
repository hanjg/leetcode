package reservoirSamling;

import java.util.Random;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class LinkedListRandomNode {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
	
	ListNode head;
	Random random;
    public LinkedListRandomNode(ListNode head) {
        this.head=head;random=new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int res=-1,count=0;
        for(ListNode node=head;node!=null;node=node.next){
        	res=random.nextInt(++count)==0?node.val:res;
        }
        return res;
    }


}

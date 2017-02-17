package linkedList;

public class DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
    	if(node.next==null)return;
    	node.val=node.next.val;
    	node.next=node.next.next;
    }

}

package hashTable;
import java.util.HashMap;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { 
		this.label = x; 
	}
}

public class CopyListwithRandomPointer {
	HashMap<RandomListNode, RandomListNode> map=new HashMap<>();
    public RandomListNode copyRandomList(RandomListNode head) {
    	RandomListNode current=head;
    	while(current!=null){
    		map.put(current, new RandomListNode(current.label));
    		current=current.next;
    	}
    	current=head;
    	while(current!=null){
    		map.get(current).next=map.get(current.next);
    		map.get(current).random=map.get(current.random);
    		current=current.next;
    	}
    	return map.get(head);
    }
    
    @SuppressWarnings("unused")
	private RandomListNode dfs(RandomListNode node){//溢出
    	if (node==null) {
			return null;
		}
    	if (map.containsKey(node)) {
			return map.get(node);
		}
    	RandomListNode newNode=new RandomListNode(node.label);
    	map.put(node, newNode);
    	newNode.next=dfs(node.next);
    	newNode.random=dfs(node.random);
    	return newNode;
    }
    
}

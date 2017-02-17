package divideAndConquer;
import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }}

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {//归并排序
    	if(lists.length==0)return null;
    	for(int k=1;k<lists.length;k*=2){
    		mergeLists(lists, k);
    	}
    	return lists[0];
    }
    
    private void mergeLists(ListNode[] lists,int k){
    	//归并的每组含有初始lists中的链表的个数k,归并结果储存在lists[l1]中
    	int l1=0,l2=l1+k;
    	while(l2<lists.length){
    		lists[l1]=mergeTwoLists(lists[l1],lists[l2]);
    		l1=l2+k;l2=l1+k;
    	}
    }

	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
	
	 public ListNode mergeKLists2(ListNode[] lists){//优先队列，即最小堆排序
		if(lists.length==0)return null;
		ListNode dum=new ListNode(0),tail=dum;
		PriorityQueue<ListNode> queue=new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
			public int compare(ListNode node1,ListNode node2){
				return node1.val-node2.val;
			}
		});
		for(ListNode head:lists){
			if(head!=null) queue.add(head);
		}
		while(!queue.isEmpty()){
			tail=tail.next=queue.poll();
			if(tail.next!=null) queue.add(tail.next);
		}
		return dum.next;
	 }

}

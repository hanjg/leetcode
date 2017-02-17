package bfs;

class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
 }

public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {//通过上一层节点连接下一层节点
        TreeLinkNode head=root;//该层节点
        while(head!=null){
        	TreeLinkNode first=head.left;//下一层的第一个节点
        	while(head!=null){
        		if(head.left!=null)head.left.next=head.right;
        		if(head.right!=null)head.right.next=head.next==null?null:head.next.left;
        		head=head.next;
        	}
        	head=first;
        }
    }
}

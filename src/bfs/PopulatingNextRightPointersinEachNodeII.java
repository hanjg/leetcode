package bfs;

public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head=root;//本层节点
        while(head!=null){
        	TreeLinkNode cur=new TreeLinkNode(0);//下一层层已经连接到的节点
        	TreeLinkNode firstPre=cur;//下一层第一个节点的前一个节点
        	while(head!=null){
        		if(head.left!=null)cur=cur.next=head.left;
        		if(head.right!=null)cur=cur.next=head.right;
        		head=head.next;
        	}
        	head=firstPre.next;
        }
    }


}

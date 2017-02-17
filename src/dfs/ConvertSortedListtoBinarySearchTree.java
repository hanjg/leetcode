package dfs;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class ConvertSortedListtoBinarySearchTree {
	ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        cur=head;
        int len=0;
        while(head!=null){len++;head=head.next;}
        return dfs(0, len-1);
    }
    private TreeNode dfs(int begin,int end){
    	if(begin>end) return null;
    	int mid=(begin+end)/2;
    	TreeNode left=dfs(begin, mid-1);
    	TreeNode root=new TreeNode(cur.val);
    	cur=cur.next;//中序遍历的次序为链表的次序
    	TreeNode right=dfs(mid+1, end);
    	root.left=left;root.right=right;
    	return root;
    }
}

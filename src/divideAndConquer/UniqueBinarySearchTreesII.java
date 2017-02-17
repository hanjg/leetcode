package divideAndConquer;
import java.util.*;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class UniqueBinarySearchTreesII {
	
    public List<TreeNode> generateTrees(int n) {
    	if(n==0)return new ArrayList<>();
    	return create(1, n);
    }
    
    private List<TreeNode> create(int begin,int end){//创建数值[begin,end]的节点
    	List<TreeNode> res=new ArrayList<>();
    	if(begin>end){
    		res.add(null);
    		return res;
    	}
    	for(int i=begin;i<=end;i++){//i作为根节点
    		List<TreeNode> left=create(begin, i-1);
    		List<TreeNode> right=create(i+1, end);
    		for(int j=0;j<left.size();j++){
    			for(int k=0;k<right.size();k++){
    				TreeNode root=new TreeNode(i);
    				root.left=left.get(j);
    				root.right=right.get(k);
    				res.add(root);
    			}
    		}
    	}
    	return res;
    }
    public static void main(String[] args){
    	new UniqueBinarySearchTreesII().generateTrees(0);
    }
    
}

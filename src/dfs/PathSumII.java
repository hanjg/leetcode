package dfs;
import java.util.*;
public class PathSumII {
	List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        dfs(root, sum, list);
        return result;
    }
    
    private void  dfs(TreeNode node,int target,List<Integer> list) {
		if (node==null) {
			return;
		}
		if (node.left==null&&node.right==null) {
			if (target==node.val) {
				List<Integer> temp=new ArrayList<>(list);
				temp.add(node.val);
				result.add(temp);
			}
			return;
		}
		if (node.left!=null) {
			list.add(node.val);dfs(node.left, target-node.val, list);
			list.remove(list.size()-1);
		}
		if (node.right!=null) {
			list.add(node.val);dfs(node.right, target-node.val, list);
			list.remove(list.size()-1);
		}
	}

}

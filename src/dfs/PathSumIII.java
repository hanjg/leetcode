package dfs;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
    	if (root == null) {
			return 0;
		}
    	return start(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
	
    /**
     * 以node为路径的起点寻找为sum的路径和
     * @param node
     * @param sum
     * @return
     */
    private int start(TreeNode node, int sum) {
    	if (node == null) {
			return 0;
		}
    	int count = 0;
    	if (node.val == sum) {
			count++;
		}
    	count += start(node.left, sum - node.val);
    	count += start(node.right, sum - node.val);
    	return count;
    }
    
    public int pathSum2(TreeNode root, int sum) {
    	List<Integer> presums = new ArrayList<>();
    	presums.add(0);
    	return dfs(root, presums, sum);
    }
    
    private int dfs(TreeNode node, List<Integer> presums, int sum) {
    	if (node == null) {
			return 0;
		}
    	int count = 0;
    	int cursum = presums.get(presums.size() - 1) + node.val;
    	for (int presum : presums) {
			if (cursum - presum == sum) {
				count++;
			}
		}
    	presums.add(cursum);
    	count += dfs(node.left, presums, sum);
    	count += dfs(node.right, presums, sum);
    	presums.remove(presums.size() - 1);
    	return count;
    }
    
}

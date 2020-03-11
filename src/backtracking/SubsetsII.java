package backtracking;
import java.util.*;
public class SubsetsII {
	List<List<Integer>>res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res=new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>());
        return res;
    }
    private void dfs(int[]nums,int cur,List<Integer> cache){
    	if(cur==nums.length){
    		res.add(new ArrayList<>(cache));return;
    	}
    	cache.add(nums[cur]);
    	dfs(nums, cur+1, cache);
    	cache.remove(cache.size()-1);
    	//当nums中存在重复的数字时，只用重复的前一部分
    	while(cur+1<nums.length&&nums[cur+1]==nums[cur])cur++;
    	dfs(nums, cur+1, cache);
    }
}

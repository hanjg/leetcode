package backtracking;

import java.util.*;
public class Permutations {
	List<List<Integer>> result;
	boolean[] used;//nums[i]是否已经使用过
    public List<List<Integer>> permute(int[] nums) {
        result=new ArrayList<>();
        used=new boolean[nums.length];
        dfs(nums, new ArrayList<Integer>());
        return result;
    }
    private void dfs(int[] nums,List<Integer> cache){//已经使用count个数
    	if (cache.size()==nums.length) {
			result.add(new ArrayList<>(cache));return;
		}
    	for(int i=0;i<nums.length;i++){
    		if(used[i])continue;
    		cache.add(nums[i]);used[i]=true;
    		dfs(nums, cache);
    		cache.remove(cache.size()-1);used[i]=false;
    	}
    }
	public List<List<Integer>> permute2(int[] nums) {
	    result=new ArrayList<List<Integer>>();
	    dfs2(nums, 0);
	    return result;
	}
	private void dfs2(int[] nums,int cur){//选取排列中下标为cur的数
		if (cur==nums.length) {
			List<Integer> cache=new ArrayList<>();
			for(int i=0;i<nums.length;i++)cache.add(nums[i]);
			result.add(cache);return;
		}
		for(int i=cur;i<nums.length;i++){//cur处的数可为nums[cur,lenght)
			swap(nums, cur, i);
			dfs2(nums, cur+1);
			swap(nums, cur, i);
		}
	}
	private void swap(int[] nums,int i,int j){
		int temp=nums[i];nums[i]=nums[j];nums[j]=temp;
	}
}

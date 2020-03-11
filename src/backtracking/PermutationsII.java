package backtracking;
import java.util.*;

public class PermutationsII {
	List<List<Integer>> result;
	boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result=new ArrayList<>();
        Arrays.sort(nums);
        used=new boolean[nums.length];
        dfs(nums, new ArrayList<Integer>());
        return result;
    }
    
    private void dfs(int[] nums,List<Integer> cache){
    	if (cache.size()==nums.length) {
			result.add(new ArrayList<>(cache));return;
		}
    	for(int i=0;i<nums.length;i++){
    		if(used[i]||(i>0&&!used[i-1]&&nums[i-1]==nums[i])) continue;
    		//重复的数只允许从第一个开始使用
    		cache.add(nums[i]);used[i]=true;
    		dfs(nums, cache);
    		cache.remove(cache.size()-1);used[i]=false;
    	}
    }

	public List<List<Integer>> permuteUnique2(int[] nums) {
	    result=new ArrayList<>();
	    dfs2(nums, 0);
	    return result;
	}
	private void dfs2(int[] nums,int cur){
		if (cur==nums.length) {
			List<Integer> cache=new ArrayList<>();
			for(int i=0;i<nums.length;i++)cache.add(nums[i]);
			result.add(cache);return;
		}
		for(int i=cur;i<nums.length;i++){
			if(i!=cur&&nums[i]==nums[cur])continue;
			swap(nums, cur, i);
			dfs2(nums, cur+1);
			swap(nums, cur, i);
		}
	}
	private void swap(int[] nums,int i,int j){
		int temp=nums[i];nums[i]=nums[j];nums[j]=temp;
	}
	
	public static void main(String[] args) {
		System.out.println(new PermutationsII().permuteUnique(new int[]{1,1,2}));
	}
}

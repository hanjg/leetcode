package backtracking;
import java.util.*;
public class CombinationSumII {
	List<List<Integer>> res;
	public List<List<Integer>> combinationSum2(int[] candidates, int target){
		res=new ArrayList<>();
		Arrays.sort(candidates);
		dfs(candidates, target, new ArrayList<Integer>(), 0);
		return res;
	}
	private void dfs(int[] candidates,int target,List<Integer> cache,int begin){
		//选取的数字的范围为[begin,candidates.length)
		if (target==0) {
			res.add(new ArrayList<>(cache));return ;
		}
		if (target>0) {
			for(int i=begin;i<candidates.length;i++){
				cache.add(candidates[i]);
				dfs(candidates, target-candidates[i], cache, i+1);
				cache.remove(cache.size()-1);
				while(i+1<candidates.length&&candidates[i+1]==candidates[i])i++;
				//cache中除去从i开始的重复的candidates[i]
			}
		}
	}
}

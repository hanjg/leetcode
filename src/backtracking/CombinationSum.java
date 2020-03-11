package backtracking;
import java.util.*;

public class CombinationSum {
	List<List<Integer>> res;
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		//Arrays.sort(candidates);
		res=new ArrayList<>();
		dfs(candidates, target, new ArrayList<Integer>(), 0);
		return res;
    }
	
	private void dfs(int[] candidates,int target,List<Integer> cache,int begin){
		//[begin,candidates.length)为下一个添加数的下标范围
		if (target==0) {
			res.add(new ArrayList<>(cache));return;
		}
		if (target>0) {
			for(int i=begin;i<candidates.length;i++){
				cache.add(candidates[i]);
				dfs(candidates, target-candidates[i], cache, i);
				cache.remove(cache.size()-1);
			}
		}
	}
	@SuppressWarnings("unused")
	private void pick2(List<List<Integer>> result,List<Integer> comb,int sum,
			int[] candidates,int begin,int target){
		//[beigin,length-1]中至少挑选一个数，使得==target
		if (begin==candidates.length) {
			return;
		}
		//candidates[begin]在组合中
		comb.add(candidates[begin]);
		sum+=candidates[begin];
		if (sum==target) {
			result.add(new ArrayList<>(comb));
			comb.remove(comb.size()-1);
			return;
		}
		else if (sum<target) {
			pick2(result, comb, sum,candidates, begin, target);
		}
		else {
			comb.remove(comb.size()-1);
			return;
		}
		//candidates[begin]不在组合中
		comb.remove(comb.size()-1);
		sum-=candidates[begin];
		while(begin+1<candidates.length&&candidates[begin]==candidates[begin+1]) begin++;//去重
		pick2(result, comb, sum, candidates, begin+1, target);
	}

	public static void main(String[] args) {
		CombinationSum combinationSum=new CombinationSum();
		int[] candidates={2, 2,2,3, 6, 7};
		System.out.println(combinationSum.combinationSum(candidates, 7));
	}

}

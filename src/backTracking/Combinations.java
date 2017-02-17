package backTracking;

import java.util.*;
public class Combinations {
	List<List<Integer>> res;
	public List<List<Integer>> combine(int n, int k) {
		res=new ArrayList<List<Integer>>();
		dfs(n, k, 1, new ArrayList<Integer>());
		return res;
    }
	private void dfs(int n,int k,int begin,List<Integer> cache){//从begin开始选择组合的数字
		if (cache.size()==k) {
			res.add(new ArrayList<>(cache));return;
		}
		for(int i=begin;i+k-cache.size()-1<=n;i++){
			cache.add(i);
			dfs(n, k, i+1, cache);
			cache.remove(cache.size()-1);
		}
	}
	public static void main(String[] args) {
		Combinations combinations=new Combinations();
		System.out.println(combinations.combine(4, 2));
	}

}

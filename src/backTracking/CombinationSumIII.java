package backTracking;
import java.util.*;
public class CombinationSumIII {
	List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result=new ArrayList<>();
    	if(n<1||n>45) return result;
        List<Integer> comb=new ArrayList<>();
        get(k, n, 1,comb);
        return result;
    }
    
    private void get(int left,int target,int begin,List<Integer> comb){
    	if (left==0&&target==0) {
			result.add(new ArrayList<>(comb));
			return ;
		}
    	else if(left==0) return;
		for(int i=begin;i<=9;i++){
			if(i>target) break;
			comb.add(i);
			get(left-1, target-i,i+1, comb);
			comb.remove(comb.size()-1);
		}
    }
}

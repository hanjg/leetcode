package bitManipulation;
import java.util.*;
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
    	int n=nums.length,nSet=(int)Math.pow(2, n);
    	List<List<Integer>> res=new ArrayList<>();
    	for(int i=0;i<nSet;i++){
    		List<Integer> temp=new ArrayList<>();
    		for(int j=0;j<n;j++){//判断是否需要在集合i中加入数nums[j]
    			if(((i>>j)&1)==0) temp.add(nums[j]);
    		}
    		res.add(temp);
    	}
    	return res;
    }
}

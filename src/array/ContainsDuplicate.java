package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashtable=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
        	if (hashtable.contains(nums[i])) {
				return true;
			}
        	else {
				hashtable.add(nums[i]);
			}
        }
        return false;
    }
    
    public boolean containsDuplicate2(int[] nums){
    	Arrays.sort(nums);
    	for(int i=0;i<nums.length-1;i++){
    		if (nums[i]==nums[i+1]) {
				return true;
			}
    	}
    	return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package twoPointer;

import java.util.*;
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>>res=new ArrayList<>();
    	Arrays.sort(nums);
    	for(int i=0;i+4<=nums.length;i++){
    		if(i>0&&nums[i]==nums[i-1])continue;
    		for(int j=i+1;j+3<=nums.length;j++){
    			if(j>i+1&&nums[j]==nums[j-1])continue;
    			int left=j+1,right=nums.length-1;
    			while (left<right) {
					int sum=nums[i]+nums[j]+nums[left]+nums[right];
					if(sum==target){
						res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
						while(left<right&&nums[left+1]==nums[left])left++;
						while(left<right&&nums[right-1]==nums[right])right--;
						left++;right--;
					}
					else if(sum<target)left++;
					else right--;
				}
    		}
    	}
    	return res;
    }

	public static void main(String[] args) {
		FourSum fourSum=new FourSum();
		int[] nums={5,5,3,5,1,-5,1,-2};
		System.out.println(fourSum.fourSum(nums, 4));
	}

}

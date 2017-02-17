package twoPointer;

import java.util.*;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res=new ArrayList<>();
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++){
			if(i>0&&nums[i]==nums[i-1])continue;//选择第一个数
			int left=i+1,right=nums.length-1;
			while(left<right){
				if (nums[left]+nums[right]==-nums[i]) {
					res.add(Arrays.asList(nums[i],nums[left],nums[right]));
					while(left<right&&nums[left+1]==nums[left])left++;
					while(left<right&&nums[right-1]==nums[right])right--;//去重
					left++;right--;
				}
				else if(nums[left]+nums[right]>-nums[i])right--;
				else left++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		ThreeSum threeSum=new ThreeSum();
		int[] nums={-1,0,1,2,-1,-4};
		System.out.println(threeSum.threeSum(nums));
	}

}

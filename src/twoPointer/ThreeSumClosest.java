package twoPointer;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		int res=Integer.MAX_VALUE,dif=Integer.MAX_VALUE;
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++){
			if(i>0&&nums[i-1]==nums[i])continue;
			int left=i+1,right=nums.length-1;
			while(left<right){
				int sum=nums[i]+nums[left]+nums[right];
				if (sum==target) return target;
				else if(sum<target){
					if(target-sum<dif){
						res=sum;dif=target-sum;
					}
					left++;
				}
				else {
					if(sum-target<dif){
						res=sum;dif=sum-target;
					}
					right--;
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		ThreeSumClosest closest=new ThreeSumClosest();
		int[] nums={1,1,1,0};
		System.out.println(closest.threeSumClosest(nums, 100));
	}

}

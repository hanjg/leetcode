package binarySearch;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        if(nums.length==0)return 0;
        long left=Integer.MIN_VALUE,right=0;//每组最大和的范围是最大的元素和所有元素的和
        //二分对象为所求值（一般为索引）
        for(int i=0;i<nums.length;i++){
        	left=Math.max(left, nums[i]);
        	right+=nums[i];
        }
        while(left<right){
        	long mid=left+(right-left)/2;
        	if(cansplit(nums, m, mid))right=mid;
        	else left=mid+1;
        }
        return (int)right;
    }
    private boolean cansplit(int[]nums,int m,long maxSum){
    	//每组的最大和为maxSum时，分成的组数是否<=m
    	int count=1,sum=0;
    	for(int i=0;i<nums.length;i++){
    		sum+=nums[i];
    		if(sum>maxSum){
    			if(++count>m)return false;
    			sum=nums[i];
    		}
    	}
    	return true;
    }
}

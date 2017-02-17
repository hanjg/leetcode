package binarySearch;

public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
    	if(nums.length==0)return -1;
    	int begin=0,end=nums.length-1;
    	while(begin<=end){
    		int mid=(begin+end)/2;
    		if(nums[mid]==target)return mid;
    		else if (nums[mid]>=nums[begin]) {//[begin,mid]递增或者mid==begin,即begin,mid在同一分支上
				if(nums[begin]<=target&&target<nums[mid])end=mid-1;
				else begin=mid+1;
			}
    		else {//mid,end在同一分支上
				if(nums[mid]<target&&target<=nums[end])begin=mid+1;
				else end=mid-1;
			}
    	}
    	return -1;
    }

}

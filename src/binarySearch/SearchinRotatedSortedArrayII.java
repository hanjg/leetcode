package binarySearch;

public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
    	if(nums.length==0) return false;
    	int begin=0,end=nums.length-1;
    	while(begin<=end){
    		int mid=(begin+end)/2;
    		if(target==nums[mid]) return true;
    		else if (nums[begin]<nums[mid]) {//begin,mid确定在同一分支
				if(target>=nums[begin]&&target<nums[mid]) end=mid-1;
				else begin=mid+1;
			}
    		else if (nums[mid]<nums[begin]) {//mid,begin确定不在同一分支
				if(target>nums[mid]&&target<=nums[end]) begin=mid+1;
				else end=mid-1;
			}
    		else {
				begin++;
			}
    	}
    	return false;
    }

}

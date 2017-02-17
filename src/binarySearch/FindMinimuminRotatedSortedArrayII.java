package binarySearch;

public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
    	if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        int begin=0,end=nums.length-1;
        while(begin<end){
			int mid=(begin+end)/2;
			if(mid>0&&nums[mid]<nums[mid-1])return nums[mid];
			else if(nums[mid]>nums[end])begin=mid+1;
			else if(nums[mid]<nums[end])end=mid;
			else end--;
		
        }
        return nums[begin];
    }


}

package binarySearch;

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
    	if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        int begin=0,end=nums.length-1;
        while(begin<end){
        	int mid=(begin+end)/2;
        	if(mid>0&&nums[mid]<nums[mid-1]) return nums[mid];
        	else if(nums[mid]>nums[end]) 
        		begin=mid+1;
    //nums[mid]>nums[end]mid在左边的序列里并且[begin,end]非递增的情况
    //nums[mid]>=nums[begin]反应了[begin,mid]有序,表示mid在左边的序列里(包括[begin,edn]递增)
        	else end=mid;
        }
        return nums[begin];
    }

}

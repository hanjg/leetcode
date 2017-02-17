package binarySearch;

public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {//存放了[1,n]的n+1个数，必有重复
        int low=1,high=nums.length-1;//在[1,n]之间查找
        while(low<high){
        	int mid=(low+high)/2;
        	int count=0;//记录<=mid的数的数量,若count<=mid,则重复的数范围在[mid+1,high]，否则[low,mid]
        	for(int i=0;i<nums.length;i++){
        		if (nums[i]<=mid) {
					count++;
				}
        	}
        	if (count<=mid) {
				low=mid+1;
			}
        	else {
				high=mid;
			}
        }
        return low;
    }

}

package twoPointer;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
    	int n=nums.length;
    	if(n==0||n==1)return n;
    	int i=1;
    	for(int j=1;j<n;j++){
    		if(nums[j]!=nums[i-1])nums[i++]=nums[j];
    	}
    	return i;
    }

}

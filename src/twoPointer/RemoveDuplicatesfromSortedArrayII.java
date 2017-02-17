package twoPointer;

public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
    	int n=nums.length;if(n<=2)return n;
    	int i=2;
    	for(int j=2;j<n;j++){//i将要插入的下标；j:判断是否插入的下标
    		if(nums[j]>nums[i-2])nums[i++]=nums[j];
    	}
    	return i;
    }
    public static void main(String[] args) {
		new RemoveDuplicatesfromSortedArrayII().removeDuplicates(new int[]{1,1,1,2,2,3});
	}
}

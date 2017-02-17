package array;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
    	if(nums.length==1)return nums[0];
    	else if(nums.length==2)return Math.max(nums[0], nums[1]);
    	else return quickSelect(nums, 0, nums.length-1, 3);
    }
    private int quickSelect(int[] nums,int low,int high,int kth){
    	int pivot=partition(nums, low, high);
    	if(pivot==kth-1) return nums[pivot];
    	else if(pivot>kth-1)return quickSelect(nums, low, pivot-1, kth);
    	else return quickSelect(nums, pivot+1, high, kth);
    }
    private int partition(int[] nums,int low,int high){
    	int temp=nums[low],pivot=low;//nums[pivot]最后用来存放temp
    	for(int i=low+1;i<high;i++){
    		if (nums[i]>temp) {
				nums[pivot++]=nums[i];
				nums[i]=nums[pivot];
			}
    	}
    	return pivot;
    }
}

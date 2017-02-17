package sort;
import java.util.Arrays;

public class KthLargestElementinanArray {
    public int findKthLargest3(int[] nums, int k) {//快速排序
    	Arrays.sort(nums);
    	return nums[nums.length-k];
    }
    
   public int findKthLargest(int[] nums, int k) {//快速选择
	   return quickSelect(nums, 0, nums.length-1,k);
	}
   
   private int quickSelect(int[] nums,int low,int high,int kth){
	   int pivot=partion(nums, low, high);
	   if(pivot==kth-1)return nums[pivot];
	   else if(pivot>kth-1)return quickSelect(nums, low, pivot-1, kth);
	   else return quickSelect(nums, pivot+1, high, kth);
   }
   private int partion(int[] nums,int low,int high){//pivot左边大于nums[low]
	   int t=nums[low];int pivot=low;
	   for(int i=low+1;i<=high;i++){
		   if (nums[i]>t) {
			nums[pivot++]=nums[i];
			nums[i]=nums[pivot];
		}
	   }
	   nums[pivot]=t;
	   return pivot;
   }

	/* public int findKthLargest2(int [] nums,int k){//快速选择
    	return findK(nums, 0, nums.length-1, k);
    }
    
    private int findK(int[] nums,int low,int high,int k){
    	//在[low,high]中寻找第k大的元素
    	if (low>=high) {
			return nums[low];
		}
    	
    	//pivot左边<pivot,右边>=pivot
    	int i=low,j=high;
    	int pivot=nums[i];
    	while(i<j){
    		while(i<j&&pivot<=nums[j]) j--;
    		if (i<j) {
				nums[i]=nums[j];
				i++;
			}
    		while(i<j&&pivot>nums[i]) i++;
    		if (i<j) {
				nums[j]=nums[i];
				j--;
			}
    	}
    	nums[i]=pivot;
    	
    	if (k==high+1-i) {//high+1-i[i,high]的元素数量
			return nums[i];
		}
    	else if (k>high+1-i) {
			return findK(nums, low, i-1, k-high+i-1);
		}
    	else {
			return findK(nums, i+1, high, k);
		}
    }*/
	public static void main(String[] args) {
		int[] nums={5,2,4,1,3,6,0};
		KthLargestElementinanArray test=new KthLargestElementinanArray();
		System.out.println(test.findKthLargest(nums,4));
	}

}

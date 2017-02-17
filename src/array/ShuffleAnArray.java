package array;
import java.util.Arrays;

public class ShuffleAnArray {
	private int[] copy;
	private int[] nums;
    public ShuffleAnArray(int[] nums) {
        copy=Arrays.copyOf(nums, nums.length);
        this.nums=nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return Arrays.copyOf(copy, copy.length);
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	for(int i=nums.length-1;i>0;i--){//通过随机数确定第i位的下标index，将nums[index]与nums[i]交换
    		int index=(int)(Math.random()*(i+1));
    		int temp=nums[index];
    		nums[index]=nums[i];
    		nums[i]=temp;
    	}
    	return nums;
    }
    
    private void print(int[] a){
    	for(int i=0;i<a.length;i++){
    		System.out.print(a[i]+" ");
    	}
    	System.out.println();
    }
    
    public static void main(String[] args){
    	int[] nums={1,2,3};
    	ShuffleAnArray test=new ShuffleAnArray(nums);
    	test.print(test.shuffle());
    	test.print(test.reset());
    	test.print(test.shuffle());
    }
}

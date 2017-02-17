package array;

public class RotateArray {
    public void rotate(int[] nums, int k) {
    	if(k==0||nums.length==0) return;
    	k=k%nums.length;
    	for(int i=nums.length-k;i<nums.length;i++){
    		int j=i;int temp=nums[j];
    		while(j>=k){
    			nums[j]=nums[j-k];j-=k;
    		}
    		nums[j]=temp;
    	}
    }

	public void rotate2(int[] nums, int k) {
		if(k==0||nums.length==0) return;
		k=k%nums.length;
		reverse(nums, 0, nums.length-1);//i->n-1-i->i-n+k||i+k
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);
	}
	
	private void reverse(int[] nums,int begin,int end){
		int temp;
		while(begin<end){
			temp=nums[begin];nums[begin]=nums[end];nums[end]=temp;
			begin++;end--;
		}
	}

}

package array;

public class FirstMissingPositive { 
    public int firstMissingPositive(int[] nums) {
    	for(int i=0;i<nums.length;i++){//将nums中[1,nums.length]的数n放下标n-1的位置(第n个位置)
    		while(nums[i]>0&&nums[i]<=nums.length&&nums[i]!=nums[nums[i]-1]){
    			//nums[i]的下标应为nums[i]-1
    			//nums[i]-1!=i&&nums[i]!=nums[nums[i]-1]等价于nums[i]!=nums[nums[i]-1]
    			int temp=nums[i];nums[i]=nums[temp-1];nums[temp-1]=temp;
    		}
    	}
    	for(int i=0;i<nums.length;i++){//若nums[i]-1!=i,则下标i对应的数缺失
    		if(nums[i]-1!=i)return i+1;
    	}
    	return nums.length+1;
    }
	public static void main(String[] args) {
		FirstMissingPositive test=new FirstMissingPositive();
		int[] nums={1,1};
		System.out.println(test.firstMissingPositive(nums));
	}

}

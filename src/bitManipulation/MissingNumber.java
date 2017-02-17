package bitManipulation;

public class MissingNumber {
    public int missingNumber(int[] nums) {//nums共n个数
        //nums[i]==i，否则缺失i
    	for(int i=0;i<nums.length;i++){
    		while(nums[i]<nums.length&&nums[i]!=i){
    			int temp=nums[i];
    			nums[i]=nums[temp];
    			nums[temp]=temp;
    		}
    	}
    	for(int i=0;i<nums.length;i++){
    		if (nums[i]!=i) {
				return i;
			}
    	}
    	return nums.length;
    }

	public int missingNumber2(int[] nums) {//nums共n个数
	    //异或运算，在[0,n-1]和n和[nums[0],nums[n-1]中只有一个数出现了一次(只在下标中出现)，即为缺失的数
		//a^b^b=a
		int result=nums.length;
		for(int i=0;i<nums.length;i++){
			result=result^i^nums[i];
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

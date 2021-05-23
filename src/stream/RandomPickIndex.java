package stream;

import java.util.Random;

public class RandomPickIndex {
	int[] nums;
	Random random;
    public RandomPickIndex(int[] nums) {
        this.nums=nums;
        random=new Random();
    }

    public int pick(int target) {
    	int res=-1,count=0;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]==target)res=random.nextInt(++count)==0?res=i:res;
    	}
    	return res;
    }
}

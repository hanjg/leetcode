package dp;

import java.util.Arrays;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] sol=new int[target+1];//目标位i的解的个数为sol[i]
        sol[0]=1;
        Arrays.sort(nums);
        for(int i=1;i<=target;i++){
        	for(int j=0;j<nums.length;j++){
        		if(nums[j]>i)break;
        		sol[i]+=sol[i-nums[j]];//以nums[j]为结尾,当nums[j]==i，集合中只存在nums[j]
        	}
        }
        return sol[target];
    }

}

package twoPointer;

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums.length==0)return;
        int i=0;
        for(int j=0;j<nums.length;j++){
        	if(nums[j]!=0)nums[i++]=nums[j];
        }
        Arrays.fill(nums, i, nums.length, 0);
    }

}

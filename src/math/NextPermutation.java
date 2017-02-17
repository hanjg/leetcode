package math;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
    	int cur=nums.length-1;//cur最终指向非增序列的第一项
    	while(cur>0&&nums[cur-1]>=nums[cur])cur--;
    	if (cur==0) {//最后一个全排列
			Arrays.sort(nums);return;
		}
    	//寻找[cur,nums.length)中比nums[cur-1]大的最小值下标
    	//之后交换cur-1和next对应的数，并将[cur,nums.length)排序
    	int next=nums.length-1;
    	while(nums[next]<=nums[cur-1])next--;
    	int temp=nums[cur-1];nums[cur-1]=nums[next];nums[next]=temp;
    	Arrays.sort(nums, cur, nums.length);
    }

}

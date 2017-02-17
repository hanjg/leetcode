package sort;

import java.util.Arrays;

public class MaximumGap {
    public int maximumGap(int[] nums) {//桶排序思想
    	if(nums==null||nums.length<2)return 0;
        int max=nums[0],min=nums[0],n=nums.length;
        for(int i=1;i<n;i++){
        	max=Math.max(max, nums[i]);
        	min=Math.min(min, nums[i]);
        }
        int range=(int)Math.ceil((double)(max-min)/(n-1));
        if(range==0)return 0;//所有数相等
        //每个桶的区间长度range,桶的个数为n-1
        //最大gap一定出现在两个不同的桶中的元素之间
        int[] buMin=new int[n-1],buMax=new int[n-1];//记录每个桶中的最大和最小元素
        Arrays.fill(buMin, Integer.MAX_VALUE);
        Arrays.fill(buMax, Integer.MIN_VALUE);
        for(int num:nums){
        	if(num==max)continue;//num为max时id可能越界
        	int id=(num-min)/range;//num所处桶的序号
        	buMin[id]=Math.min(buMin[id], num);
        	buMax[id]=Math.max(buMax[id], num);
        }
        int previous=buMax[0],maxGap=previous-min;
        for(int i=1;i<n-1;i++){
        	if(buMax[i]==Integer.MIN_VALUE&&buMin[i]==Integer.MAX_VALUE)continue;
        	maxGap=Math.max(maxGap, buMin[i]-previous);
        	previous=buMax[i];
        }
        maxGap=Math.max(maxGap, max-previous);//max单独考虑
        return maxGap;
    }
}

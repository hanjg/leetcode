package twoPointer;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int minBegin=0,minEnd=nums.length-1,minLength=Integer.MAX_VALUE;
        int begin=0,end=-1;
        int sum=0;
        while(end+1<nums.length){
        	while(sum<s&&end+1<nums.length){
        		end++;
        		sum+=nums[end];
        	}
        	while(sum>=s&&begin<=end){
        		if (end-begin+1<minLength) {
					minBegin=begin;minEnd=end;minLength=end-begin+1;
				}
        		begin++;
        		sum-=nums[begin-1];
        	}
        }
        return minLength==Integer.MAX_VALUE?0:minEnd-minBegin+1;
    }

}

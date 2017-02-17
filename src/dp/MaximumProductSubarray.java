package dp;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        if(n==0)return 0;
        if(n==1)return nums[0];
        int[] dp1=new int[n];//以i结尾的正数最大值
        int[] dp2=new int[n];//负数最小值
        if(nums[0]<0)dp2[0]=nums[0];
        else dp1[0]=nums[0];
        int max=nums[0];
        for(int i=1;i<n;i++){
        	dp1[i]=Math.max(nums[i], Math.max(dp1[i-1]*nums[i], dp2[i-1]*nums[i]));
        	dp2[i]=Math.min(nums[i], Math.min(dp2[i-1]*nums[i], dp1[i-1]*nums[i]));
        	max=Math.max(max, dp1[i]);
        }
        return max;
    }

}

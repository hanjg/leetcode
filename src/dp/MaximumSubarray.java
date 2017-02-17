package dp;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
    	int n=nums.length;
    	if(n==0)return 0;
    	if(n==1)return nums[0];
    	int[] dp=new int[n];//以nums[i]结尾的最大子数组的和
    	dp[0]=nums[0];int max=dp[0];
    	for(int i=1;i<n;i++){
    		dp[i]=Math.max(dp[i-1]+nums[i], nums[i]);
    		max=Math.max(max, dp[i]);
    	}
    	return max;
    }
    
    public static void main(String[] args){
    	int[] nums={-2,1,-3,4,-1,2,1,-5,4};
    	System.out.println(new MaximumSubarray().maxSubArray(nums));
    }
}

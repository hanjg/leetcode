package dp;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {//转化为背包问题
    	int sum=0;
    	for(int num:nums)sum+=num;
    	if((sum&1)!=0)return false;
    	int m=nums.length,half=sum/2;
    	int[][] dp=new int[m+1][half+1];//前i个物品在容量为j的限制下最大价值为dp[i][j]
    	//前i个数在总和为j的限制下最大和为dp[i][j]
    	for(int i=1;i<=m;i++){
    		for(int j=nums[i-1];j<=half;j++){
    			dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-nums[i-1]]+nums[i-1]);//第i个数是否放
    		}
    	}
    	return dp[m][half]==half;
    }
    public static void main(String[] args) {
		System.out.println(new PartitionEqualSubsetSum().canPartition(new int[]{1, 2, 3, 5}));
	}
}

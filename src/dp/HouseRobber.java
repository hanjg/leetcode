package dp;

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        if(nums.length==2)return Math.max(nums[0], nums[1]);
        int[] dp=new int[nums.length];//最后盗窃下标为i的屋子
        dp[0]=nums[0];dp[1]=nums[1];
        dp[2]=Math.max(nums[1], nums[0]+nums[2]);
        for(int i=3;i<nums.length;i++){
        	dp[i]=Math.max(dp[i-2], dp[i-3])+nums[i];
        }
        return Math.max(dp[nums.length-1], dp[nums.length-2]);
    }

	public int rob2(int[] nums) {
	    if(nums==null||nums.length==0)return 0;
	    if(nums.length==1)return nums[0];
	    int[] dp=new int[nums.length];//盗窃[0,i]的最大和
	    dp[0]=nums[0];dp[1]=Math.max(nums[0], nums[1]);
	    for(int i=2;i<nums.length;i++){
	    	dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
	    }
	    return dp[nums.length-1];
	}

}

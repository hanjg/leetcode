package dp;

public class HouseRobberII {
    public int rob(int[] nums) {
	    if(nums==null||nums.length==0)return 0;
	    if(nums.length==1)return nums[0];
	    int n=nums.length;
	    int[] dp1=new int[n];//抢第一间
	    int[] dp2=new int[n];//不抢第一间
	    dp1[0]=nums[0];dp1[1]=dp1[0];
	    dp2[0]=0;dp2[1]=nums[1];
	    for(int i=2;i<n-1;i++){
	    	dp1[i]=Math.max(dp1[i-1], dp1[i-2]+nums[i]);
	    	dp2[i]=Math.max(dp2[i-1], dp2[i-2]+nums[i]);
	    }
	    dp1[n-1]=dp1[n-2];
	    dp2[n-1]=n==2?nums[1]:Math.max(dp2[n-2], dp2[n-3]+nums[n-1]);
	    return Math.max(dp1[n-1], dp2[n-1]);
    }

}

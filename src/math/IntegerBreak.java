package math;

public class IntegerBreak {
    public int integerBreak(int n) {
    	if(n==2)return 1;
    	if(n==3)return 2;
        if(n%3==0)return (int)Math.pow(3, n/3);
        if(n%3==2)return (int)Math.pow(3, n/3)*2;
        return (int)Math.pow(3, n/3-1)*4;
    }

	public int integerBreak2(int n) {
		int[] dp=new int[n+1];
		dp[1]=1;
		for(int i=2;i<=n;i++){
			for(int j=1;j<=i-1;j++){//j*(i-j)
				dp[i]=Math.max(dp[i], Math.max(j, dp[j])*Math.max(i-j, dp[i-j]));
			}
		}
		return dp[n];
	}
}

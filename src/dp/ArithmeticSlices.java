package dp;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int n=A.length;
        if(n<3)return 0;
        int[]dp=new int[n];//以A[i]结尾的序列个数
        for(int i=2;i<n;i++){
        	if(dp[i-1]==0) dp[i]=A[i]-A[i-1]==A[i-1]-A[i-2]?1:0;
        	else {
				dp[i]=A[i]-A[i-1]==A[i-1]-A[i-2]?dp[i-1]+1:0;
			}
        }
        int sum=0;
        for(int i=2;i<n;i++)sum+=dp[i];
        return sum;
    }
}

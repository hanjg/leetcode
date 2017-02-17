package bitManipulation;

public class CountNumberswithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        int[]dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
        	dp[i]=A(10,i)-A(9,i-1)+dp[i-1];
        }
        return dp[n];
    }
    private int A(int m,int n){//A(m,n)
    	int res=1;
    	while(n>0){res*=m;m--;n--;}
    	return res;
    }
}

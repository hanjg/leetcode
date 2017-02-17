package dp;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] amount=new int[n+1];//amount[i]表示数字i需要至少amount[i]个完全平方数相加
        amount[1]=1;
        for(int i=2;i<=n;i++){
        	int min=i;
        	int j=1;
        	while(j*j<=i){
        		if (j*j==i) {
					min=1;break;
				}
				min=Math.min(min, amount[i-j*j]+1);//1(j*j)+amount[i-j*j]
        		j++;
        	}
        	amount[i]=min;
        }
        return amount[n];
    }

}

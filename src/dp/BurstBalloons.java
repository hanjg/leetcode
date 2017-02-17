package dp;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
    	int n=nums.length;
        int[] money=new int[n+2];//money[i]第i个气球代表的钱i-[1,n]
        money[0]=money[n+1]=1;
        for(int i=0;i<n;i++) money[i+1]=nums[i];
        
        int[][] dp=new int[n+2][n+2];
        //dp[i][j] 戳破(i,j)所有气球得到的钱的最大值,ij第ij个,且都存在
        
        for(int amount=1;amount<=n;amount++){//amount(i,j)之间的的气球数量
        	for(int i=0;i+amount<=n;i++){//计算dp[i,j]
        		int j=i+amount+1;
        		for(int last=i+1;last<j;last++){
        			dp[i][j]=Math.max(dp[i][j],
        				money[i]*money[j]*money[last]+dp[i][last]+dp[last][j]);
        		}
        	}
        }
        
        for(int i=0;i<=n+1;i++){
        	for(int j=0;j<=n+1;j++){
        		System.out.print(dp[i][j]+"\t");
        	}
        	System.out.println();
        }
        return dp[0][n+1];
    }
    public static void main(String[] args){
    	int[] nums={3,1,5,8};
    	System.out.println(new BurstBalloons().maxCoins(nums));
    }
}

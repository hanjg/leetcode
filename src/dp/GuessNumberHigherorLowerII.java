package dp;

public class GuessNumberHigherorLowerII {
	int[][] dp;//[i,j]之间最少需要准备的钱
    public int getMoneyAmount(int n) {
        dp=new int[n+1][n+1];
        return minMax(1, n);
    }
    
    private int minMax(int begin,int end){
    	if(begin>=end)return 0;
    	if(dp[begin][end]!=0)return dp[begin][end];
    	int res=Integer.MAX_VALUE;//dp[begin,end]-cut
    	for(int cut=begin;cut<=end;cut++){//猜的数为cut
    		int temp=cut+Math.max(minMax(cut+1, end), minMax(begin, cut-1));
    		//不同cut最坏情况下需要花的钱(不可控),取其最小值(可控)
    		res=Math.min(res, temp);
    	}
    	dp[begin][end]=res;
    	return res;
    }
    public static void main(String[] args){
    	System.out.println(new GuessNumberHigherorLowerII().getMoneyAmount(2));
    }
}

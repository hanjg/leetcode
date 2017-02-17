package dp;

public class BestTimetoBuyandSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        if(n==0||n==1)return 0;
        if(k>=n/2){//n天最多进行n-1次交易否则同一天买进和卖出为无效交易
        	int max=0;
        	for(int i=0;i+1<n;i++){
        		if(prices[i]<prices[i+1])max+=prices[i+1]-prices[i];
        	}
        	return max;
        }
        int[][] local=new int[n][k+1];//[0,i]天发生j次交易，第i天有交易
        int[][] global=new int[n][k+1];//[0,i]天发生j次交易，第i天不一定有交易
        for(int i=1;i<n;i++){
        	for(int j=1;j<=k;j++){
        		//local分prices[i]>,<=prices[i-1]讨论
        		local[i][j]=Math.max(local[i-1][j]+prices[i]-prices[i-1], global[i-1][j-1]);
        		//global分第i天是否有交易讨论
        		global[i][j]=Math.max(local[i][j], global[i-1][j]);
        	}
        }
        return global[n-1][k];
    }

}

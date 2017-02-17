package dp;

public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        if(prices.length==0)return 0; 
        int n=prices.length;
        int[] preMP=new int[n];//[0,i]的最大收益
        int[] postMP=new int[n];//[i,n-1]的最大收益
        preMP[0]=postMP[n-1]=0;
        int minIn=prices[0],maxOut=prices[n-1];
        
        for(int i=1;i<n;i++){
        	minIn=Math.min(minIn, prices[i]);
        	preMP[i]=Math.max(preMP[i-1], prices[i]-minIn);
        }
        for(int i=n-2;i>=0;i--){
        	maxOut=Math.max(maxOut, prices[i]);
        	postMP[i]=Math.max(postMP[i+1], maxOut-prices[i]);
        }
        int max=0;
        for(int i=0;i<n;i++){
        	max=Math.max(max, preMP[i]+postMP[i]);
        }
        return max;
    }

}

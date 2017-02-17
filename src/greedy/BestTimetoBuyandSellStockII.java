package greedy;

public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        if(prices.length==0)return 0;
        int max=0;
        for(int i=0;i+1<prices.length;i++){
        	if(prices[i+1]>prices[i]) max+=prices[i+1]-prices[i];
        }
        return max;
    }

}

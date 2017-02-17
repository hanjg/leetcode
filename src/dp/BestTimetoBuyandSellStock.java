package dp;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)return 0;
        int minIn=prices[0],maxPro=0;//到i时最小进价和最大利润
        for(int i=1;i<prices.length;i++){
        	minIn=Math.min(minIn, prices[i]);
        	maxPro=Math.max(maxPro, prices[i]-minIn);
        }
        return maxPro;
    }

}

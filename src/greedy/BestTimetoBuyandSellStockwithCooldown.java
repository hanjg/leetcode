package greedy;


public class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==0||n==1)return 0;
        int[] hold=new int[n];//第i天结束时持有股票的利润最大值
        int[] unhold=new int[n];
        hold[0]=-prices[0];unhold[0]=0;
        hold[1]=Math.max(hold[0], -prices[1]);
        unhold[1]=Math.max(0, prices[1]-prices[0]);
        for(int i=2;i<n;i++){
        	hold[i]=Math.max(unhold[i-2]-prices[i], hold[i-1]);
        	unhold[i]=Math.max(hold[i-1]+prices[i], unhold[i-1]);
        }
        return unhold[n-1];
    }

	public int maxProfit2(int[] prices) {
	    int n=prices.length;
	    if(n==0||n==1)return 0;
	    int preUnHold=0,preHold=-prices[0];
	    int hold=Math.max(preHold, -prices[1]),unHold=Math.max(preUnHold, prices[1]-prices[0]);
	    //分别表示前一天和前两天是否持有股票的四种状态的最大利润
	    for(int i=2;i<prices.length;i++){
	    	preHold=hold;//hold[i-1]
	    	hold=Math.max(preUnHold-prices[i], hold);//hold[i]
	    	preUnHold=unHold;//unHold[i-1]
	    	unHold=Math.max(preHold+prices[i], preUnHold);
	    }
	    return unHold;
	}

}

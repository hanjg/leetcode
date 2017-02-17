package dp;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
    	if(amount==0)return 0;
    	int[] dp=new int[amount+1];//取amount钱最少的钱币数量
    	Arrays.sort(coins);Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[0]=0;
    	for(int target=1;target<=amount;target++){
    		for(int i=0;i<coins.length;i++){//第一枚取coins[i]
    			if(target<coins[i])break;
    			if(dp[target-coins[i]]!=Integer.MAX_VALUE)
    				dp[target]=Math.min(dp[target], dp[target-coins[i]]+1);
    		}
    	}
    	return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}

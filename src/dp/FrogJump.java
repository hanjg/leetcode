package dp;

import java.util.*;

public class FrogJump {
    public boolean canCross(int[] stones) {
    	//用map存储stones[i]的坐标和到达stones[i]时的所有弹跳力
	    int n=stones.length;
	    if(n==0||stones[0]!=0)return false;
	    HashMap<Integer, Set<Integer>> map=new HashMap<>();
	    for(int s:stones)map.put(s, new HashSet<Integer>());//给每个石头的坐标建立集合
	    
	    map.get(0).add(0);
	    if(map.containsKey(1)){
	    	map.get(1).add(1);
	    }
	    
	    for(int i=1;i<n;i++){
	    	int pos=stones[i];
	    	Set<Integer> jump=map.get(pos);
	    	for(int j:jump){
	    		if(j-1!=0&&map.containsKey(pos+j-1))map.get(pos+j-1).add(j-1);
	    		if(j!=0&&map.containsKey(pos+j))map.get(pos+j).add(j);
	    		if(map.containsKey(pos+j+1))map.get(pos+j+1).add(j+1);
	    	}
	    }
	    return !map.get(stones[n-1]).isEmpty();
	}
	public boolean canCross2(int[] stones) {
    	//错误，dp[i]只存储了到达i的最大弹跳力，
    	//但是能到达终点的情况下，到达i的弹跳力不一定是最大弹跳力
    	int n=stones.length;
    	if(stones[1]!=1)return false;
    	int[] dp=new int[n];//到达i的最大弹跳力为dp[i]
    	dp[1]=1;
    	for(int i=1;i<n;i++){
    		if(dp[i]==0)continue;
    		for(int j=i+1;j<n;j++){//i向j跳
    			int gap=stones[j]-stones[i];
    			if(gap>dp[i]+1)break;
    			else if(gap==dp[i]-1||gap==dp[i]||gap==dp[i]+1)dp[j]=Math.max(dp[j], gap);
    		}
    	}
    	return dp[n-1]!=0;
    }
    public static void main(String[] args) {
		System.out.println(new FrogJump().canCross(new int[]{0,1,3,5,6,8,12,17}));
	}
}

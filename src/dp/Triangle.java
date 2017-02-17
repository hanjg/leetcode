package dp;
import java.util.*;
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        if(n==0)return 0;
        if(n==1)return triangle.get(0).get(0);
        int[] dp=new int[n];
        dp[0]=triangle.get(0).get(0);
        for(int i=1;i<n;i++){
        	dp[i]=dp[i-1]+triangle.get(i).get(i);
        	for(int j=i-1;j>0;j--)dp[j]=Math.min(dp[j-1], dp[j])+triangle.get(i).get(j);
        	dp[0]=dp[0]+triangle.get(i).get(0);
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)min=Math.min(min, dp[i]);
        return min;
    }
}

package dp;

public class EditDistance {
    public int minDistance(String word1, String word2) {
    	int m=word1.length(),n=word2.length();
    	int[][] dp=new int[m+1][n+1];////word1前i个字符转化为word2前j个字符最少的操作次数
    	for(int i=1;i<=m;i++) dp[i][0]=i;
    	for(int j=1;j<=n;j++) dp[0][j]=j;
    	for(int i=1;i<=m;i++){
    		for(int j=1;j<=n;j++){//考虑从str1A->str2B
    			if (word1.charAt(i-1)==word2.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1];
				}
    			else {//str1A->str2后插入B;删除A后str1->str2B;str1->str2后A替换为B
    				dp[i][j]=1+Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
				}
    		}
    	}
    	return dp[m][n];
    }
}

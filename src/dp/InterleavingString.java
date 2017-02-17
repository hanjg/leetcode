package dp;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
    	if(s1.length()+s2.length()!=s3.length())return false;
    	boolean[][] dp=new boolean[s1.length()+1][s2.length()+1];
    	//dp[i][j]:s1中前i个和s2中前j个是否交叉排序成s3中前i+j个字符
    	dp[0][0]=true;
    	for(int i=1;i<=s1.length();i++){
    		if(s1.charAt(i-1)!=s3.charAt(i-1))break;
    		dp[i][0]=true;
    	}
    	for(int j=1;j<=s2.length();j++){
    		if(s2.charAt(j-1)!=s3.charAt(j-1))break;
    		dp[0][j]=true;
    	}
    	for(int i=1;i<=s1.length();i++){
    		for(int j=1;j<=s2.length();j++){
    			dp[i][j]=(dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1))||
    					(dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
    		}
    	}
    	return dp[s1.length()][s2.length()];
    }
}

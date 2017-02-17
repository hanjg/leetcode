package bitManipulation;

public class DecodeWays {
    public int numDecodings(String s) {
    	if(s.length()==0)return 0;
        int[] dp=new int[s.length()+1];//[0,i)的最大组合数:前i个字符最大组合数
        dp[0]=dp[1]=s.charAt(0)=='0'?0:1;
        for(int i=2;i<=s.length();i++){
        	if(s.charAt(i-1)=='0'){
        		if(s.charAt(i-2)=='1'||s.charAt(i-2)=='2')dp[i]=dp[i-2];
        		else dp[i]=0;
        	}
        	else if(s.charAt(i-1)>='1'&&s.charAt(i-1)<='6'){
        		if(s.charAt(i-2)=='1'||s.charAt(i-2)=='2')dp[i]=dp[i-2]+dp[i-1];
        		else dp[i]=dp[i-1];
        	}else {
				if(s.charAt(i-2)=='1')dp[i]=dp[i-2]+dp[i-1];
				else dp[i]=dp[i-1];
			}
        }
        return dp[s.length()];
    }

	public int numDecodings2(String s) {
		if(s.length()==0)return 0;
	    int[] dp=new int[s.length()+1];//[0,i)的最大组合数:前i个字符最大组合数
	    dp[0]=1;
	    dp[1]=s.charAt(0)=='0'?0:1;
	    for(int i=2;i<=s.length();i++){
	    	int one=Integer.valueOf(s.substring(i-1,i));
	    	int two=Integer.valueOf(s.substring(i-2,i));
	    	if(one!=0)dp[i]+=dp[i-1];//第i位不为0
	    	if(two>=10&&two<=26)dp[i]+=dp[i-2];//第i-1和第i位能组成合理数字
	    }
	    return dp[s.length()];
	}
}

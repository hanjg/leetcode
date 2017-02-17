package dp;

import java.util.Stack;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {//dp
    	int m=s.length(),n=p.length();
    	boolean[][] dp=new boolean[m+1][n+1];//s前i个字符和p前j个字符是否匹配
    	dp[0][0]=true;
    	for(int j=2;j<=n;j++) dp[0][j]=dp[0][j-2]&&p.charAt(j-1)=='*';
    	for(int i=1;i<=m;i++){
    		for(int j=1;j<=n;j++){
    			if(p.charAt(j-1)!='*')
    				dp[i][j]=dp[i-1][j-1]&&(p.charAt(j-1)=='.'||p.charAt(j-1)==s.charAt(i-1));
    			else//该位置的*表示的字符数为0或者>=1(>=1考虑s前i-1个字符和p前j个字符匹配) 
    				dp[i][j]=dp[i][j-2]||
    					(dp[i-1][j]&&(p.charAt(j-2)=='.'||p.charAt(j-2)==s.charAt(i-1)));
    		}
    	}
    	for(int i=0;i<=m;i++){
    		for(int j=0;j<=n;j++) System.out.print(dp[i][j]+"\t");
    		System.out.println();
    	}
    	return dp[m][n];
    }

	public boolean isMatch2(String s, String p) {
    	boolean[] match=new boolean[s.length()+1];//s中[i,s.length)是否匹配
    	match[s.length()]=true;
    	for(int ip=p.length()-1;ip>=0;ip--){
    		if(p.charAt(ip)=='*'){
    			for(int is=s.length()-1;is>=0;is--){
    				match[is]=match[is]||(match[is+1]&&(p.charAt(ip-1)=='.'||p.charAt(ip-1)==s.charAt(is)));
    			}
    			ip--;
    		}else {
				for(int is=0;is<s.length();is++){
					match[is]=match[is+1]&&(p.charAt(ip)=='.'||p.charAt(ip)==s.charAt(is));
				}
				match[s.length()]=false;
			}
    	}
    	return match[0];
    }

	public boolean isMatch3(String s, String p) {//超时
	    int is=0,ip=0;
	    Stack<Integer> isMatch=new Stack<>();
	    Stack<Integer> ipStar=new Stack<>();
	    //p中带*的字符的下标和在s中匹配的连续字符的下标（不包括该字符）
	    while(is<s.length()){
	    	if ((ip==p.length()-1||ip+1<p.length()&&p.charAt(ip+1)!='*')&&
	    			(p.charAt(ip)=='.'||p.charAt(ip)==s.charAt(is))) {
				ip++;is++;
			}
	    	else if (ip+1<p.length()&&p.charAt(ip+1)=='*') {
				isMatch.push(is);ipStar.push(ip);
				ip+=2;
			}
	    	else if (!ipStar.isEmpty()&&
	    			(p.charAt(ipStar.peek())=='.'||s.charAt(isMatch.peek())==p.charAt(ipStar.peek()))) {
				is=isMatch.pop()+1;isMatch.push(is);
	    		ip=ipStar.peek()+2;
			}
	    	else if (ipStar.size()>1) {
				isMatch.pop();ipStar.pop();
				is=isMatch.pop();isMatch.push(is);
	    		ip=ipStar.peek();			
	    		}
	    	else {
				return false;
			}
	    }
	    while(ip+1<p.length()&&p.charAt(ip+1)=='*') ip+=2;
	    return ip==p.length();
	}

	public static void main(String[] args){
		System.out.println(new RegularExpressionMatching().isMatch("aaa", "a*"));
	}

}

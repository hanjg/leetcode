package dp;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {//dp
    	int m=s.length(),n=p.length();
    	boolean[][] dp=new boolean[m+1][n+1];//s的前i个字符是否与p的前j个字符匹配
    	dp[0][0]=true;
    	for(int j=1;j<=n;j++){
    		if(p.charAt(j-1)=='*')dp[0][j]=true;
    		else break;
    	}
    	for(int i=1;i<=m;i++){
    		for(int j=1;j<=n;j++){
    			if (p.charAt(j-1)!='*') {
					dp[i][j]=dp[i-1][j-1]&&(p.charAt(j-1)=='?'||p.charAt(j-1)==s.charAt(i-1));
				}
    			else {
					dp[i][j]=dp[i][j-1]||dp[i-1][j];//p[j-1]是否代表空字符
					//dp[i][j]=dp[i][j-1]||dp[i-1][j-1]||...||dp[0][j-1]
				}
    		}
    	}
    	return dp[m][n];
    }
    
    public boolean isMatch2(String s, String p) {//greedy
    	int is=0,ip=0;//s,p中的下标
    	int ismatch=-1,ipstar=-1;//ipstar匹配的s中字符串右边界（不包括）的下标；p中*的下标
    	while(is<s.length()){
    		/*if (ip<p.length()){
				System.out.println("s["+is+"]="+s.charAt(is)+"\t"+"p["+ip+"]="+p.charAt(ip)+
						"\t"+"abefcdgiescdfimde"+" ab*cd?i*de");
			}*/
    		if (ip<p.length()&&(p.charAt(ip)=='?'||p.charAt(ip)==s.charAt(is))) {
				ip++;is++;
			}
    		else if (ip<p.length()&&p.charAt(ip)=='*') {
				ismatch=is;ipstar=ip++;//因为*可匹配空字符不is++
			}
    		else if (ipstar!=-1) {
				is=++ismatch;ip=ipstar+1;//*匹配的字符串增加s[ismatch]这个字符
			}
    		else {
				return false;
			}
    	}
    	while(ip<p.length()&&p.charAt(ip)=='*')ip++;
    	return ip==p.length();
    }
    public static void main(String[] args) {
		System.out.println(new WildcardMatching().isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
	}
}

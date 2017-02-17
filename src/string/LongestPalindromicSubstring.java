package string;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {//Manacher算法
    	if(s.length()==0)return s;
    	StringBuilder builder=new StringBuilder("$");
    	for(int i=0;i<s.length();i++){builder.append('#');builder.append(s.charAt(i));}
    	builder.append('#');
    	String string=builder.toString();//s预处理
    	
    	int[] dp=new int[string.length()];
    	//以string中下标为i的字符为中心的回文串左右延伸的最大长度
    	int idl=0,len=0;//最长回文串的中心下标和延伸的长度
    	int idf=0,mf=0;//向右延伸最远的回文串的中心下标和延伸到的下标
    	for(int i=1;i<string.length();i++){
    		dp[i]=i<mf?Math.min(dp[2*idf-i], mf-i):0;
    		int j=i+dp[i]+1;
    		while(j<string.length()&&string.charAt(j)==string.charAt(2*i-j)){dp[i]++;j++;}
    		if(dp[i]>len){idl=i;len=dp[i];}
    		if(i+dp[i]>mf){idf=i;mf=i+dp[i];}
    	}
    	//以字母为中心和以#为中心(idl-len+1)/2-1;
    	//idl-len+1为第一个字母在string中的下标，/2表示在s中为第几个字母
    	return s.substring((idl-len-1)/2, (idl+len-1)/2);
    }
    
    public String longestPalindrome2(String s){//dp
    	int n=s.length();if(n==0)return s;
    	int begin=0,end=0;
    	boolean[][] dp=new boolean[n][n];//[i,j]是否回文
    	for(int i=0;i<n;i++)dp[i][i]=true;
    	for(int i=0;i+1<n;i++){
    		if(s.charAt(i)==s.charAt(i+1)){
    			dp[i][i+1]=true;begin=i;end=i+1;
    		}
    	}
    	for(int len=3;len<=n;len++){
    		for(int i=0;i+len-1<n;i++){
    			int j=i+len-1;
    			dp[i][j]=s.charAt(i)==s.charAt(j)&&dp[i+1][j-1];
    			if(dp[i][j]&&j-i>end-begin){begin=i;end=j;}
    		}
    	}
    	return s.substring(begin, end+1);
    }
    
    public String longestPalindrome3(String s){//dp改进
    	int n=s.length();if(n==0)return s;
    	int begin=0,end=0;
    	for(int i=0;i<n;i++){//i为中心
    		int len=0;//向左右扩展len个字符
    		while(i-len>=0&&i+len<n&&s.charAt(i-len)==s.charAt(i+len))len++;
    		len--;
    		if(2*len>end-begin){begin=i-len;end=i+len;}
    	}
    	for(int i=0;i+1<n;i++){//i,i+1为中心
    		if(s.charAt(i)!=s.charAt(i+1))continue;
    		int len=0;
    		while(i-len>=0&&i+1+len<n&&s.charAt(i-len)==s.charAt(i+1+len))len++;
    		len--;
    		if(2*len+1>end-begin){begin=i-len;end=i+1+len;}
    	}
    	return s.substring(begin, end+1);
    }
    
    public static void main(String[] args){
    	System.out.println(new LongestPalindromicSubstring().longestPalindrome("a"));
    }
}

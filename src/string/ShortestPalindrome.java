package string;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {//bf算法
        int n=s.length();
        if(n==0||n==1)return s;
        char[] cs=s.toCharArray();
        int max=0;
        for(int len=1;len<=n;len++){
        	int i,half=len/2;
        	for(i=0;i<half;i++){//判断[0,len-1]是否为回文串,即从0开始长度为len的字符串
        		if(cs[i]!=cs[len-1-i]) break;
        	}
        	if(i==half)max=len;
        }
        if(max==n)return s;
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<n-max;i++){
        	builder.append(cs[n-1-i]);
        }
        return builder.toString()+s;
    }
    public String shortestPalindrome2(String s) {
        int i=0;
        for(int j=s.length()-1;j>=0;j--){
        	if(s.charAt(j)==s.charAt(i))i++;
        }
        if(i==s.length())return s;//s回文串
        return new StringBuilder(s.substring(i)).reverse().toString()+
        		shortestPalindrome2(s.substring(0, i))+s.substring(i);
    }

    
    public static void main(String[]args){
    	System.out.println(new ShortestPalindrome().shortestPalindrome2("aacecaaa"));
    }
}

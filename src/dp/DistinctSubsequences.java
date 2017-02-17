package dp;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int[][] methods=new int[s.length()+1][t.length()+1];
        //methods[i][j]:s中前i个字符转化为t中前j个字符的方法数量
        methods[0][0]=1;
        for(int i=1;i<=s.length();i++){
        	methods[i][0]=1;
        }
        for(int i=1;i<=t.length();i++) methods[0][i]=0;
        for(int i=1;i<=s.length();i++){
        	for(int j=1;j<=t.length();j++){
        		if (s.charAt(i-1)==t.charAt(j-1)) {
        			//比较s的第i个字符和t的第j个字符,相等则s的第i个字符可以保留作为t的第j个字符，或者删除
					methods[i][j]=methods[i-1][j-1]+methods[i-1][j];
				}
        		else {
					methods[i][j]=methods[i-1][j];
				}
        	}
        }
        return methods[s.length()][t.length()];
    }

}

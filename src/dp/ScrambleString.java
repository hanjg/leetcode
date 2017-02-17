package dp;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
    	if(s1.length()!=s2.length()) return false;
    	if(s1.equals(s2)) return true;
    	int n=s1.length();
    	//dp[len][i][j]:s1[i,i+len)和s2[j,j+len)互相scrmable
    	boolean[][][] dp=new boolean[n+1][n][n];
    	for(int i=0;i<n;i++){
    		for(int j=0;j<n;j++){
    			dp[1][i][j]=s1.charAt(i)==s2.charAt(j);
    		}
    	}
    	for(int len=2;len<=n;len++){
    		for(int i=0;i+len<=n;i++){
    			for(int j=0;j+len<=n;j++){
    				for(int k=1;k<len;k++){//s1[i,i+len)和s2[j,j+len)分为长度为k和len-k的两段
    					if ((dp[k][i][j]&&dp[len-k][i+k][j+k])||(dp[k][i][j+len-k]&&dp[len-k][i+k][j])) {
							dp[len][i][j]=true;
							break;
						}
    				}
    			}
    		}
    	}
    	return dp[n][0][0];
    }
    @SuppressWarnings("unused")
	private void print(boolean[][][] scramble,int n){
    	for(int len=1;len<=n;len++){
    		for(int i=0;i<n;i++){
    			for(int j=0;j<n;j++){
    				System.out.print(len+","+i+","+j+"="+scramble[len][i][j]+"\t");
    			}
    			System.out.println();
    		}
    		System.out.println();
    	}
    	System.out.println("---------------");
    }

	public static void main(String[] args) {
		ScrambleString scrambleString=new ScrambleString();
		System.out.println(scrambleString.isScramble("ab", "ba"));
	}
}

package dp;

public class PalindromePartitioningII {
    public int minCut(String s) {
    	int n=s.length();
    	boolean[][] isPal=new boolean[n][n];//[i,j]是否回文
    	int[] min=new int[n];//[0,i]切成回文子串的最小切割次数
    	for(int end=0;end<n;end++){
    		min[end]=Integer.MAX_VALUE;
    		for(int begin=end;begin>=0;begin--){
    			if(s.charAt(begin)==s.charAt(end)&&(begin+1>=end||isPal[begin+1][end-1])){
    				isPal[begin][end]=true;
    				min[end]=Math.min(min[end], begin==0?0:(min[begin-1]+1));
    		//begin==0?0:(min[begin-1]+1)切割出以[begin,end]回文子串结尾的最小切割次数
    			}
    		}
    	}
    	return min[n-1];
    }
    public static void main(String[] args) {
		System.out.println(new PalindromePartitioningII().minCut("abbab"));
	}
}

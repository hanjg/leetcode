package dp;
import java.util.*;
public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
    	boolean[]dp=new boolean[s.length()+1];//[0,i)是否可分解
    	int maxLen=0;
    	for(String string:wordDict)maxLen=Math.max(maxLen, string.length());
    	dp[0]=true;
    	for(int end=1;end<=s.length();end++){
    		for(int begin=end>maxLen?end-maxLen:0;begin<=end;begin++){
    			if(wordDict.contains(s.substring(begin, end))&&dp[begin]==true)
    				dp[end]=true;
    		}
    	}
    	return dp[s.length()];
    }
    
    
}

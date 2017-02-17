package twoPointer;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
    	if(s.length()==0)return 0;
    	int max=0,i=0,j=0;
    	boolean[] map=new boolean[128];//[i,j)是否含有该字符
    	for(;j<s.length();j++){
    		char c=s.charAt(j);//将要加入s[j]
    		while(map[c])map[s.charAt(i++)]=false;
    		map[c]=true;
    		max=Math.max(max, j-i+1);
    	}
    	return max;
    }
    
    public static void main(String[] args){
    	System.out.println(new LongestSubstringWithoutRepeatingCharacters().
    			lengthOfLongestSubstring("abcabcbb"));
    }
}

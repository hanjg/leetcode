package string;

public class LongestSubstringwithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
    	if(k<=1)return s.length();
        int[]count=new int[26];
        for(int i=0;i<s.length();i++) count[s.charAt(i)-'a']++;
        
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<26;i++)
        	if(count[i]>0&&count[i]<k)builder.append((char)(i+'a')+"|");
        
        if(builder.length()==0)return s.length();
        else {
			builder.deleteCharAt(builder.length()-1);
			String[]subs=s.split(builder.toString());
			int max=0;
			for(String sub:subs){
				max=Math.max(max, longestSubstring(sub, k));
			}
			return max;
		}
    }
    public static void main(String[] args) {
		System.out.println(new LongestSubstringwithAtLeastKRepeatingCharacters().
				longestSubstring("aaabb", 3));
	}
}

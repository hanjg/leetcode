package hashTable;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] count=new int[128];
        for(int i=0;i<s.length();i++)count[s.charAt(i)]++;
        int remove=0;
        boolean haveodd=false;
        for(int i=0;i<128;i++){
        	if((count[i]&1)==1){
        		if(haveodd)remove++;
        		else haveodd=true;
        	}
        }
        return s.length()-remove;
    }
    public static void main(String[] args) {
		System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
	}
}

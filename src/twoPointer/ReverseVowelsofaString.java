package twoPointer;

public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        char[] cs=s.toCharArray();
        int i=0,j=s.length()-1;
        while(i<j){
        	while(!isVo(cs[i])&&i<j)i++;
        	while(!isVo(cs[j])&&i<j)j--;
        	char temp=cs[i];cs[i]=cs[j];cs[j]=temp;
        	i++;j--;
        }
    	return new String(cs);
    }	
    private boolean isVo(char c){
    	return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||
    			c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
    }

}

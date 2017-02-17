package string;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
    	if(strs.length==0)return "";
        StringBuilder builder=new StringBuilder();
        Arrays.sort(strs);
        char[] a=strs[0].toCharArray(),b=strs[strs.length-1].toCharArray();
        int len=Math.min(a.length, b.length);
        for(int i=0;i<len;i++){
        	if(a[i]==b[i])builder.append(a[i]);
        	else break;
        }
        return builder.toString();
    }

	public String longestCommonPrefix2(String[] strs) {
		if(strs.length==0)return "";
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<strs[0].length();i++){
			for(int j=1;j<strs.length;j++){
				if(i==strs[j].length()||strs[j].charAt(i)!=strs[0].charAt(i))return builder.toString();
			}
			builder.append(strs[0].charAt(i));
		}
		return builder.toString();
	}


}

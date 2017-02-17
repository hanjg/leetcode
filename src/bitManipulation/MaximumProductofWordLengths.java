package bitManipulation;

public class MaximumProductofWordLengths {
    public int maxProduct(String[] words) {//用bit操作判断两个字母串是否存在相同的字母
        int[] val=new int[words.length];//val[i]的二进制编码1、0表示words[i]中是否存在对应的字母
        //0b100表示存在字符'c',不存在'a','b'
        for(int i=0;i<words.length;i++){
        	String string=words[i];
        	for(int j=0;j<string.length();j++){
        		val[i]|=1<<(string.charAt(j)-'a');
        	}
        }
        int max=0;
        for(int i=1;i<words.length;i++){
        	for(int j=0;j<i;j++){
        		if ((val[i]&val[j])==0) {//不存在相同的字母
					max=Math.max(max, words[i].length()*words[j].length());
				}
        	}
        }
        return max;
    }

}

package string;
import java.util.*;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> result=new ArrayList<>();
    	for(int i=0;i<words.length;i++){
    		String string=words[i];
    		int len=words[i].length();//当前行的字符串、有效长度
    		int begin=i;//本行在words中的范围[begin,i]
    		while(i+1<words.length&&len+1+words[i+1].length()<=maxWidth){
    			len+=1+words[++i].length();
    		}
    		int num=i-begin;//本行单词之间的间隔数
    		if (num==0) {
				while(string.length()<maxWidth) string+=' ';
			}
    		else {
    			int average=(maxWidth-len)/num,particular=(maxWidth-len)%num;
        		//每个间隔需要增加的空格数和前par个间隔需要增加一个空格
        		for(int j=begin+1;j<=i;j++){
        			for(int k=0;k<average;k++) string+=' ';
        			if(j-begin<=particular) string+=' ';
        			string+=' '+words[j];
        		}
			}
    		result.add(string);
    	}
    	String[] lastwords=result.get(result.size()-1).split(" ");
    	System.out.println(result.get(result.size()-1));
    	for(int i=0;i<lastwords.length;i++) System.out.print(lastwords[i]+" ");
    	String string="";
    	for(int i=0;i<lastwords.length;i++){
    		if(lastwords[i].isEmpty()) continue;
    		if(i!=0) string+=' ';
    		string+=lastwords[i];
    	}
    	while(string.length()<maxWidth) string+=' ';
    	result.set(result.size()-1, string);
    	return result;
    }
    public static void main(String[] args) {
		System.out.println(new TextJustification().fullJustify(new String[]{"What","must","be","shall","be."}, 12));
	}
}

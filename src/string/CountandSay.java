package string;

public class CountandSay {
    public String countAndSay(int n) {
    	String string="1";
    	for(int i=2;i<=n;i++){//得到第i个字符串
    		StringBuilder builder=new StringBuilder();
    		for(int j=0;j<string.length();j++){
    			char c=string.charAt(j);int count=1;
    			while(j+1<string.length()&&string.charAt(j+1)==c){
    				count++;j++;
    			}
    			builder.append(count);builder.append(c);
    		}
    		string=builder.toString();
    	}
    	return string;
    }
    public static void main(String[] args){
    	System.out.println(new CountandSay().countAndSay(10));
    }
}

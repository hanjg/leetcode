package string;

public class ReverseWordsinaString {
    public String reverseWords(String s) {
    	s=s.trim();
        String[] strings=s.split(" ");
        if(strings.length<=1)return s;
        StringBuilder builder=new StringBuilder();
        for(int i=strings.length-1;i>=0;i--){
        	if(strings[i].length()==0)continue;
        	builder.append(strings[i]);
        	builder.append(" ");
        }
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }
    public String reverseWords2(String s) {
    	s=s.trim();
    	if(s.length()==0)return s;
		char[] chars=s.toCharArray();
		reverse(chars, 0, s.length());
		int begin=0,end=0;
		for(int i=0;i<chars.length;i++){
			if(chars[i]==' '){
				reverse(chars, begin, end);
				begin=++end;
			}else {
				end++;
			}
		}
		reverse(chars, begin, end);
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<chars.length-1;i++){
			if(chars[i]==' '&&chars[i+1]==' ')continue;
			builder.append(chars[i]);
		}
		builder.append(chars[chars.length-1]);
		return builder.toString();
	}
    private void reverse(char[] chars,int begin,int end){
    	end--;
    	while(begin<end){
    		char c=chars[begin];chars[begin]=chars[end];chars[end]=c;
    		begin++;end--;
    	}
    }
    
	public static void main(String[] args) {
		System.out.println(new ReverseWordsinaString().reverseWords("   a   b "));
	}
}

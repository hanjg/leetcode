package math;

public class StringtoIntegeratoi {
    public int myAtoi(String str) {
    	if(str.length()==0)return 0;
    	long res=0,sign=1;
    	str=str.trim();
    	int i=0;char c=str.charAt(0);
    	if (c=='+'||c=='-') {
			if(i+1<str.length()&&Character.isDigit(str.charAt(i+1))){sign=c=='+'?1:-1;i++;}
			else return 0;
		}
    	while(i<str.length()&&Character.isDigit(str.charAt(i))){
    		res=res*10+str.charAt(i)-'0';i++;
    		if(sign==1&&sign*res>Integer.MAX_VALUE)return Integer.MAX_VALUE;
    		else if(sign==-1&&sign*res<Integer.MIN_VALUE)return Integer.MIN_VALUE;
    	}
    	return (int)(sign*res);
    }
    public static void main(String[] args) {
		System.out.println(new StringtoIntegeratoi().myAtoi("  -0012a42"));
	}

}

package stack;

public class BasicCalculatorII {
    public int calculate(String s) {
    	s=s.replace(" ", "");
    	int res=0,cur=0,sign=1;
    	for(int i=0;i<s.length();i++){
    		char c=s.charAt(i);
    		if(c=='+'){
    			res+=sign*cur;
    			sign=1;
    		}
    		else if (c=='-') {
				res+=sign*cur;
				sign=-1;
			}
    		else if (c=='*') {
				int temp=0;
				while(i+1<s.length()&&Character.isDigit(s.charAt(i+1))){
					i++;temp=10*temp+s.charAt(i)-'0';
				}
				cur*=temp;
			}
    		else if (c=='/') {
				int temp=0;
				while(i+1<s.length()&&Character.isDigit(s.charAt(i+1))){
					i++;temp=10*temp+s.charAt(i)-'0';
				}
				cur/=temp;
			}
    		else {
				cur=s.charAt(i)-'0';
				while(i+1<s.length()&&Character.isDigit(s.charAt(i+1))){
					i++;cur=10*cur+s.charAt(i)-'0';
				}
			}
    	}
        return res+sign*cur;
    }

}

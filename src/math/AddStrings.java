package math;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder builder=new StringBuilder();
        int carry=0;
        for(int i=num1.length()-1,j=num2.length()-1;i>=0||j>=0;){
        	int t=carry;
        	if(i>=0)t+=num1.charAt(i--)-'0';
        	if(j>=0)t+=num2.charAt(j--)-'0';
        	builder.append(t%10);
        	carry=t/10;
        }
        if(carry==1)builder.append(1);
        return builder.reverse().toString();
    }


}

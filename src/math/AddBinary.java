package math;

public class AddBinary {
    public String addBinary(String a, String b) {
    	StringBuilder builder=new StringBuilder();
    	int i=a.length()-1,j=b.length()-1,carry=0;//carry表示进位
    	while(i>=0||j>=0){
    		int sum=carry;
    		if(i>=0) sum+=a.charAt(i--)-'0';
    		if(j>=0) sum+=b.charAt(j--)-'0';
    		builder.append(sum%2);
    		carry=sum/2;
    	}
    	if(carry==1) builder.append(1);
    	return builder.reverse().toString();
    }

}
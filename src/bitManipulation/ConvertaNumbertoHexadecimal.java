package bitManipulation;

public class ConvertaNumbertoHexadecimal {
    public String toHex(int num) {
    	if(num==0)return "0";
    	char[] he={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder builder=new StringBuilder();
        while(num!=0){
        	builder.append(he[num&15]);
        	num>>>=4;
        	//>>>无符号右移，高位补0
        	//>>右移，高位补符号位1或者0，如>>1表示除2
        }
        return builder.reverse().toString();
    }
    public static void main(String[] args) {
		System.out.println(new ConvertaNumbertoHexadecimal().toHex(-1));
	}
}

package math;

public class DivideTwoIntegers {
	//dividend可以分解为pow(2，n)*divisor的多项式，系数为divisor
    public int divide(int dividend, int divisor) {
    	if(divisor==0)return Integer.MAX_VALUE;
    	if(dividend==Integer.MIN_VALUE){
    		if(divisor==1)return Integer.MIN_VALUE;
    		if(divisor==-1)return Integer.MAX_VALUE;
    	}
    	int sign=(dividend<0)^(divisor<0)?-1:1;
    	long dd=Math.abs((long)dividend),ds=Math.abs((long)divisor);
    	int res=0;
    	while(dd>=ds){
    		long item=ds,mul=1;//多项式的项item和mul=pow(2,n);dd=pow(2,n)*ds的多项式
    		while((item<<1)<=dd){
    			item<<=1;mul<<=1;
    		}
    		res+=mul;dd-=item;
    	}
    	return sign==1?res:-res;
    }
    public static void main(String[] args) {
		System.out.println(new DivideTwoIntegers().divide(-2147483648, 2));
	}
}

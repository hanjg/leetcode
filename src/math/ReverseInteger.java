package math;

public class ReverseInteger {
    public int reverse(int x) {
    	long data=Math.abs(x),res=0;
    	while(data>0){
    		res=10*res+data%10;
    		data/=10;
    	}
    	return (int)(x>0?(res>Integer.MAX_VALUE?0:res):
    		(-res<Integer.MIN_VALUE?0:-res));
    }
}

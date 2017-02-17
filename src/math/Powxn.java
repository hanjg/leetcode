package math;

public class Powxn {
    public double myPow(double x, int n) {
    	if(n==0)return 1;
    	return n%2==0?myPow(x*x, n/2):(n>0?x:1/x)*myPow(x*x, n/2);
    }

	public double myPow2(double x, int n) {
		if(n==0)return 1;
		double res=1;
		long absN=Math.abs((long)n);
		while(absN>0){
			if (absN%2==0) {
				x*=x;absN>>=1;
			}
			else {
				res*=x;absN--;
			}
		}
		return n<0?1/res:res;
	}
	public static void main(String[] args) {
		System.out.println(new Powxn().myPow2(3, 2));
	}
}

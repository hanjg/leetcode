package math;

public class Sqrtx {
    public int mySqrt(int x) {
    	long begin=0,end=x;
    	while(begin<end){
    		long mid=(begin+end+1)/2;
    		if(mid*mid==x)return (int)mid;
    		else if(mid*mid>x) end=mid-1;
    		else begin=mid;
    	}
    	return (int)begin;
    }

	public int mySqrt2(int x) {
		long res=x;
		while(res*res>x){
			res=(res+x/res)/2;
		}
		return (int)res;
	}

}

package math;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long l=1,r=num;
        while(l<=r){
        	long mid=(l+r)>>1;
        	if(mid*mid==num)return true;
        	else if(mid*mid<num)l=mid+1;
        	else r=mid-1;
        }
        return false;
    }

	public boolean isPerfectSquare2(int num) {
	    int count=1;
	    while(num>0){
	    	num-=count;count+=2;
	    }
	    return num==0;
	}
	
}

package math;

public class SuperPow {
	int m=1337;
    public int superPow(int a, int[] b) {
        a=a%m;
        int end=b.length-1;
        return smod(a, b, end);
    }
    
    private int smod(int a,int[] b,int end){
    	if(end==0)return modm(a, b[0]);
    	else {
			return modm(smod(a, b, end-1), 10)*(modm(a, b[end]))%m;
		}
    }
    
    private int modm(int a,int b){//pow(a,b)%m
    	int res=1;
    	while(b>0){
    		res=res*a%m;b--;
    	}
    	return res;
    }
}

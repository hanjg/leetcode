package bitManipulation;

public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        return Integer.bitCount(n)==1;
    }

	
	public boolean isPowerOfTwo2(int n) {
		return n>0&&((n&(n-1))==0);
	}

}

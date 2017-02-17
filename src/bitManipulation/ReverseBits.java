package bitManipulation;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int r=0;
        for(int i=0;i<32;i++){
        	r|=((n>>i)&1)<<(31-i);
        }
        return r;
    }

}

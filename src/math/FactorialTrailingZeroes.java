package math;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        long pow=5,amount=n/pow;
        int total=0;
        while(amount>0){
        	total+=amount;
        	pow*=5;
        	amount=n/pow;
        }
        return total;
    }

	public int trailingZeroes2(int n) {
		return n==0?0:(n/5+trailingZeroes(n/5));
	}
}

package math;

public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        if (n<=0) {
			return false;
		}
        return (int)(Math.log(Integer.MAX_VALUE)/Math.log(3))%3==0;//n为3的19次方的质因数
    }


}

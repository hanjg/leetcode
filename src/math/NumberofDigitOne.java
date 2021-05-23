package math;

/**
 * problems-233 https://leetcode-cn.com/problems/number-of-digit-one/
 */
public class NumberofDigitOne {
    public int countDigitOne(int n) {
        int count=0;
        for(long base=1;base<=n;base*=10){
        	long q=n/base,r=n%base;
        	count+=(q+8)/10*base+(q%10==1?r+1:0);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberofDigitOne().countDigitOne(13));
    }
}

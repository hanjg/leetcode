package bitManipulation;

/**
 * problems-231 https://leetcode-cn.com/problems/power-of-two/
 */
public class PowerofTwo {

    public boolean isPowerOfTwo(int n) {
        //n二进制最后一个1->0
        return n > 0 && ((n & (n - 1)) == 0);
    }
}

package bitManipulation;

/**
 * problems-231 https://leetcode-cn.com/problems/power-of-two/
 */
public class PowerofTwo {

    public boolean isPowerOfTwo(int n) {
        //最低位的1变成0
        return n > 0 && ((n & (n - 1)) == 0);
    }
}

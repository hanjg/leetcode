package bitManipulation;

/**
 * problems-260 https://leetcode-cn.com/problems/single-number-iii/
 */
public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        //两个只出现一次的数的异或值 xor = x^y
        int xor = 0;
        for (int num1 : nums) {
            xor ^= num1;
        }
        //保留最低位的1，其余全部置0，这个1只能来自其中的一个，如x
        int dif = xor & (-xor);
        int y = xor;
        for (int num : nums) {
            if ((num & dif) > 0) {
                //只和x异或不和y异或
                y ^= num;
            }
        }
        return new int[]{xor ^ y, y};
    }
}

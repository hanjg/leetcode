package bitManipulation;

/**
 * problems-137 https://leetcode-cn.com/problems/single-number-ii//
 */
public class SingleNumberII {

    /**
     * 通解
     */
    public int singleNumber(int[] nums) {
        //用数组来储存所有数据中各个二进制位上1出现的次数
        int[] bitCount = new int[32];
        for (int num : nums) {
            for (int offset = 0; offset < 32; offset++) {
                if ((num & (1 << offset)) != 0) {
                    bitCount[offset]++;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < bitCount.length; i++) {
            if (bitCount[i] % 3 > 0) {
                //过滤掉出现3次的数据后重新组装
                result |= 1 << i;
            }
        }
        return result;
    }

    @SuppressWarnings("unused")
    private void print(int ones, int twos, int threes) {
        System.out.println(Integer.toBinaryString(ones) + "\t" + Integer.toBinaryString(twos) + "\t"
                + Integer.toBinaryString(threes));
    }

    /**
     * 特解
     */
    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0, threes = 0;//第i位只出现1、2、3次的掩码变量，二进制码的第i位为1代表这一位出现1、2、3次
        for (int i = 0; i < nums.length; i++) {
            //System.out.println("nums["+i+"]="+Integer.toBinaryString(nums[i]));
            twos |= ones & nums[i];//print(ones, twos, threes);
            ones ^= nums[i];//print(ones, twos, threes);
            // 异或3次 和 异或 1次的结果是一样的

            //对于ones 和 twos 把出现了3次的位置设置为0 （取反之后1的位置为0）
            threes = ones & twos;//print(ones, twos, threes);
            ones &= ~threes;//print(ones, twos, threes);
            twos &= ~threes;//print(ones, twos, threes);
        }
        return ones;
    }

    public static void main(String[] args) {
        SingleNumberII test = new SingleNumberII();
        int[] nums = {-2, -2, 1, 1, 4, 1, 4, 4, -4, -2};
        System.out.println(test.singleNumber(nums));
//        System.out.println(Integer.toBinaryString(-4));
//        System.out.println(Integer.toBinaryString((-4)&(1<<31)));
    }

}

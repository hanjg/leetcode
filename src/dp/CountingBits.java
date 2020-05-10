package dp;

/**
 * problems-338 https://leetcode-cn.com/problems/counting-bits/
 */
public class CountingBits {

    public int[] countBits(int num) {
        int[] count = new int[num + 1];
        count[0] = 0;
        //r[i]=r[i/2]+i%2
        for (int i = 1; i <= num; i++) {
            count[i] = count[i >> 1] + i % 2;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] r = new CountingBits().countBits(2);
        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i] + " ");
        }
    }
}

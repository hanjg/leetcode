package math;

/**
 * problems-470 https://leetcode-cn.com/problems/implement-rand10-using-rand7/
 */
public class ImplementRand10UsingRand7 extends SolBase {

    /**
     * 拒绝采样：两次rand7共49个结果，选取其中前40个实现rand10，后面9个丢弃
     */
    public int rand10() {
        int val;
        do {
            int row = rand7();
            int col = rand7();
            val = (row - 1) * 7 + col;
        } while (val > 40);
        return 1 + val % 10;
    }
}

class SolBase {

    public int rand7() {
        return 1;
    }
}
package weekly;

/**
 * https://leetcode-cn.com/problems/number-of-laser-beams-in-a-bank/
 */
public class NumberofLaserBeamsinaBank {

    public int numberOfBeams(String[] bank) {
        int sum = 0;
        int lastRow = -1, lastCount = -1;
        for (int curRow = 0; curRow < bank.length; curRow++) {
            int curCount = count1(bank[curRow]);
            if (curCount == 0) {
                continue;
            }
            if (lastRow != -1) {
                //除了：第一排、和前一排紧靠
                sum += lastCount * curCount;
            }

            lastRow = curRow;
            lastCount = curCount;
        }
        return sum;
    }

    private int count1(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new NumberofLaserBeamsinaBank().numberOfBeams(new String[]{"011001", "000000", "010100", "001000"}));
    }
}

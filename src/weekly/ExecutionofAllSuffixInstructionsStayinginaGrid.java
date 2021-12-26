package weekly;

/**
 * https://leetcode-cn.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/
 */
public class ExecutionofAllSuffixInstructionsStayinginaGrid {

    public int[] executeInstructions(int n, int[] startPos, String s) {
        char[] cs = s.toCharArray();
        int[] result = new int[cs.length];
        for (int i = 0; i < cs.length; i++) {
            int row = startPos[0];
            int col = startPos[1];
            int count = 0;
            for (int j = i; j < cs.length; j++) {
                if (cs[j] == 'U') {
                    row--;
                } else if (cs[j] == 'D') {
                    row++;
                } else if (cs[j] == 'L') {
                    col--;
                } else if (cs[j] == 'R') {
                    col++;
                }
                if (row < 0 || row >= n || col < 0 || col >= n) {
                    break;
                }
                count++;
            }
            result[i] = count;
        }
        return result;
    }
}

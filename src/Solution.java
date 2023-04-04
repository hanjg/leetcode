/**
 * @author anxi
 * @version 2023/4/4 19:39
 */
class Solution {

    private final long[] sum;
    private long total;

    private final int[][] rects;

    public Solution(int[][] rects) {
        sum = new long[rects.length + 1];
        for (int i = 1; i <= rects.length; i++) {
            int[] rect = rects[i - 1];
            long area = (long) (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            sum[i] = sum[i - 1] + area;
            total += area;
        }
        this.rects = rects;
    }

    public int[] pick() {
        long r = (long) (Math.random() * total);
        int index = 0;
        while (sum[index + 1] < r) {
            index++;
        }

        long targetSum = r - sum[index];
        int[] targetRect = rects[index];
        int lenX = targetRect[2] - targetRect[0] + 1;
        return new int[]{(int) (targetRect[0] + targetSum % lenX), (int) (targetRect[1] + targetSum / lenX)};
    }

}
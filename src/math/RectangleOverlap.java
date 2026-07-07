package math;


/**
 * problems-836 https://leetcode.cn/problems/rectangle-overlap/description/
 */
public class RectangleOverlap {

    /**
     * 如果两个矩形重叠，那么它们重叠的区域一定也是一个矩形，
     * 那么这代表了两个矩形与 x 轴平行的边（水平边）投影到 x 轴上时会有交集，与 y 轴平行的边（竖直边）投影到 y 轴上时也会有交集
     * <p>
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];

        int X1 = rec2[0];
        int Y1 = rec2[1];
        int X2 = rec2[2];
        int Y2 = rec2[3];

        return !(X1 >= x2 || X2 <= x1 || Y1 >= y2 || Y2 <= y1);
    }

    public static void main(String[] args) {
        System.out.println(new RectangleOverlap().isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}));
    }


}

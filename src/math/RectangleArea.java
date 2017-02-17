package math;

public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int length=Math.min(Math.min(C-A, G-A), Math.min(C-E, G-E));
        int height=Math.min(Math.min(D-B, H-B), Math.min(D-F, H-F));
        return (C-A)*(D-B)+(G-E)*(H-F)-(length<=0||height<=0?0:length*height);
    }

}

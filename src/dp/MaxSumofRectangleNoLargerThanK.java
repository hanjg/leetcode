package dp;

import java.util.*;

/**
 * problems-363 https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 */
public class MaxSumofRectangleNoLargerThanK {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        if (cols == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        for (int l = 0; l < cols; l++) {
            int[] rowSums = new int[rows];//记录列[j1,j2]每行的和
            for (int r = l; r < cols; r++) {
                for (int i = 0; i < rows; i++) {
                    rowSums[i] += matrix[i][r];
                }
                TreeSet<Integer> set = new TreeSet<>();//记录之前每一个[0,i][j1,j2]的和
                int val = 0;//记录当前[0,i][j1,j2]的和
                for (int i = 0; i < rows; i++) {
                    val += rowSums[i];
                    if (val <= k) {
                        res = Math.max(res, val);
                    }
                    Integer temp = set.ceiling(val - k);//之前[0,x]的和
                    if (temp != null) {
                        res = Math.max(res, val - temp);//val-temp（两行之间的和）<=k的最大值
                    }
                    set.add(val);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{5, -4, 5}, {1, -4, -4}, {5, 4, -3}, {-3, 5, -4}};
        System.out.println(new MaxSumofRectangleNoLargerThanK().maxSumSubmatrix(matrix, 8));
    }
}

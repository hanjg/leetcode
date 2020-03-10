package binarySearch;

/**
 * problems-240 https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class Searcha2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        //矩阵一行中每个数递增，一列中每个数递增，左下和右上相当于中间值（类似二分法）
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        //从左下开始，<target则行-1，>target则列+1
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Searcha2DMatrixII().searchMatrix(new int[][]{{-1, 3}}, 3);
    }
}

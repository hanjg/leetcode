package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * problems-417 https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
 */
public class PacificAtlanticWaterFlow {

    int m, n;
    List<int[]> res;
    int[][] dirs;

    public List<int[]> pacificAtlantic(int[][] matrix) {
        res = new ArrayList<>();
        m = matrix.length;
        if (m == 0) {
            return res;
        }
        n = matrix[0].length;
        if (n == 0) {
            return res;
        }
        dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //(i,j)是否能流入两个大洋
        boolean[][] at = new boolean[m][n], pa = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, at, i, n - 1);
            dfs(matrix, pa, i, 0);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, at, m - 1, j);
            dfs(matrix, pa, 0, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (at[i][j] && pa[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, boolean[][] reach, int i, int j) {
        if (reach[i][j]) {
            return;
        }
        reach[i][j] = true;
        for (int k = 0; k < dirs.length; k++) {
            int x = i + dirs[k][0], y = j + dirs[k][1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] >= matrix[i][j]) {
                dfs(matrix, reach, x, y);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        new PacificAtlanticWaterFlow().pacificAtlantic(matrix);
    }
}

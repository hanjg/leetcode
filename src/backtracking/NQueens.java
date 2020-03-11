package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * problem-51 https://leetcode-cn.com/problems/n-queens/
 */
public class NQueens {

    private List<List<String>> result = new ArrayList<>();
    private boolean[] colMap; // 列占位图
    private boolean[] addMap; // 横纵坐标和相等的占位图
    private boolean[] delMap; // 横纵坐标差相等的占位图

    public List<List<String>> solveNQueens(int n) {
        colMap = new boolean[n];
        addMap = new boolean[2 * n - 1];
        delMap = new boolean[2 * n - 1];
        dfs(0, n, new int[n]);
        return result;
    }

    /**
     * 注意终止条件+选择列表+回溯路径
     *
     * @param row 设置row行
     * @param position position[i]=j : 第i行放在第j列
     */
    private void dfs(int row, int n, int[] position) {
        if (row == n) {
            result.add(generateSolution(position));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValidPosition(row, col, position)) {
                setPosition(row, col, position);
                dfs(row + 1, n, position);
                unSetPosition(row, col, position);
            }
        }
    }

    private void setPosition(int row, int col, int[] position) {
        position[row] = col;
        colMap[col] = true;
        addMap[row + col] = true;
        delMap[row - col + position.length - 1] = true;
    }

    private void unSetPosition(int row, int col, int[] position) {
        position[row] = 0;
        colMap[col] = false;
        addMap[row + col] = false;
        delMap[row - col + position.length - 1] = false;
    }

    private boolean isValidPosition(int row, int col, int[] position) {
        return !colMap[col] && !addMap[row + col] && !delMap[row - col + position.length - 1];
    }

    private List<String> generateSolution(int[] position) {
        List<String> res = new ArrayList<>(position.length);
        for (int row = 0; row < position.length; row++) {
            StringBuilder builder = new StringBuilder();
            for (int col = 0; col < position.length; col++) {
                builder.append(position[row] == col ? 'Q' : '.');
            }
            res.add(builder.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }
}

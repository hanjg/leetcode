package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * problems-407 https://leetcode-cn.com/problems/trapping-rain-water-ii/
 *
 * @see twoPointer.TrappingRainWater
 */
public class TrappingRainWaterII {

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        //周围柱子高度的最小堆，类似2D中的leftMax,rightMax
        PriorityQueue<Bar> queue = new PriorityQueue<>(2 * m + 2 * n, Comparator.comparingInt(bar -> bar.height));
        //(i,j)是否访问过
        boolean[][] visited = new boolean[m][n];
        //之后访问的方向：上下左右
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //初始化
        for (int i = 0; i < m; i++) {
            queue.add(new Bar(i, 0, heightMap[i][0]));
            queue.add(new Bar(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            queue.add(new Bar(0, j, heightMap[0][j]));
            queue.add(new Bar(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = visited[m - 1][j] = true;
        }
        int res = 0;
        while (!queue.isEmpty()) {
            Bar bar = queue.poll();
            for (int[] dir : dirs) {
                int x = bar.x + dir[0];
                int y = bar.y + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    //临接短板的接水量
                    res += Math.max(0, bar.height - heightMap[x][y]);
                    //到达临接短板的高度较大值
                    queue.add(new Bar(x, y, Math.max(bar.height, heightMap[x][y])));
                    visited[x][y] = true;
                }
            }
        }
        return res;
    }

    class Bar {

        int x, y, height;

        Bar(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
}

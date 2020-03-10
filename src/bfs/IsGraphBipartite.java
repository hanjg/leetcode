package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * problems-785 https://leetcode-cn.com/problems/is-graph-bipartite/
 */
public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int v = 0; v < graph.length; v++) {
            if (color[v] > 0) {
                continue;
            }
            int curColor = 1;
            color[v] = curColor;
            Queue<Integer> queue = new LinkedList<>();
            for (int i : graph[v]) {
                queue.add(i);
            }
            while (!queue.isEmpty()) {
                curColor = curColor == 1 ? 2 : 1;
                int num = queue.size();
                for (int i = 0; i < num; i++) {
                    int cur = queue.poll();
                    color[cur] = curColor;
                    for (int next : graph[cur]) {
                        if (color[next] > 0 && color[next] == curColor) {
                            //相邻节点颜色如果相同，则不是二分图
                            return false;
                        } else if (color[next] == 0) {
                            queue.add(next);
                        }
                    }
                }
            }
        }
        return true;
    }
}

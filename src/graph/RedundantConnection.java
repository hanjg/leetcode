package graph;

/**
 * problems-684 https://leetcode-cn.com/problems/redundant-connection/
 */
public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] edge : edges) {
            if (uf.connected(edge[0], edge[1])) {
                return edge;
            }
            uf.union(edge[0], edge[1]);
        }
        return new int[0];
    }

    /**
     * 并查集：通过各自根节点是否相同，检查两点之间的连通性
     */
    private class UnionFind {

        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int findRoot(int i) {
            if (parent[i] == i) {
                return i;
            }
            //寻找根节点
            int root = i;
            while (parent[root] != root) {
                root = parent[root];
            }
            //必要时压缩路径
            int cur = i;
            while (parent[cur] != cur) {
                int p = parent[cur];
                parent[cur] = root;
                cur = p;
            }
            return root;
        }

        public boolean connected(int i, int j) {
            return findRoot(i) == findRoot(j);
        }

        public void union(int i, int j) {
            int root1 = findRoot(i);
            int root2 = findRoot(j);
            if (root1 == root2) {
                return;
            }
            parent[root2] = root1;
        }
    }
}

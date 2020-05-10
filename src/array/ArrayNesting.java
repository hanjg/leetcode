package array;

/**
 * problems-565 https://leetcode-cn.com/problems/array-nesting/
 */
public class ArrayNesting {

    public int arrayNesting(int[] nums) {
        //类似dfs，访问过的路径不再访问
        boolean[] visited = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = 0;
            while (!visited[i]) {
                visited[i] = true;
                len++;
                i = nums[i];
            }
            res = Math.max(res, len);
        }
        return res;
    }
}

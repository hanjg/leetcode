package dp;

/**
 * problems-887 https://leetcode-cn.com/problems/super-egg-drop/
 */
public class SuperEggDrop {

    /**
     * @param K 鸡蛋数
     * @param N 层数
     */
    public int superEggDrop(int K, int N) {
        //dp[k][m]:k个鸡蛋摔m次可以测试的楼层数
        int[][] dp = new int[K + 1][N + 1];
        int m = 0;
        while (dp[K][m] < N) {
            //测试没有完全覆盖N层，增加测试次数
            m++;
            for (int k = 1; k <= K; k++) {
                //摔碎楼层+当前楼层+没摔碎楼层
                dp[k][m] = dp[k - 1][m - 1] + 1 + dp[k][m - 1];
            }
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(new SuperEggDrop().superEggDrop(1, 2));
    }

}

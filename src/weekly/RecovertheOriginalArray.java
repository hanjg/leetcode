package weekly;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/recover-the-original-array/
 */
public class RecovertheOriginalArray {

    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        //lower[0]必定是lower[0]
        //higher[0]必定在nums[1~n]
        int lStart = 0;
        //枚举higer[0]
        for (int hStart = 1; hStart <= n / 2; hStart++) {
            if ((nums[hStart] - nums[lStart]) % 2 != 0) {
                continue;
            }
            int k = (nums[hStart] - nums[lStart]) / 2;
            if (k == 0) {
                continue;
            }

            int[] result = new int[n / 2];
            int rIndex = 0;

            int l = lStart;
            int h = hStart;
            boolean[] visited = new boolean[n];
            visited[l] = visited[h] = true;
            result[rIndex++] = nums[l] + k;

            while (l < n && h < n) {
                //寻找下一个lower
                while (l < n && visited[l]) {
                    l++;
                }
                //停止在1<n 未访问
                if (l >= n) {
                    break;
                }
                visited[l] = true;
                //寻找下一个higher，
                while (h < n && (visited[h] || nums[h] - nums[l] < 2 * k)) {
                    h++;
                }
                //停止在h<n 且未访问 且相差==2k
                if (h >= n || nums[h] - nums[l] > 2 * k) {
                    break;
                }
                int[] t = nums;
                int lnum = nums[l];
                int hnum = nums[h];
                visited[h] = true;
                result[rIndex++] = nums[l] + k;
            }

            if (rIndex == n / 2) {
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        for (int i : new RecovertheOriginalArray().recoverArray(new int[]{11, 6, 3, 4, 8, 7, 8, 7, 9, 8, 9, 10, 10, 2, 1, 9})) {
            System.out.print(i + ", ");
        }
    }
}

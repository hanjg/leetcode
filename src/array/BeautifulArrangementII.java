package array;

/**
 * problems-667 https://leetcode-cn.com/problems/beautiful-arrangement-ii/
 */
public class BeautifulArrangementII {

    public int[] constructArray(int n, int k) {
        //两种极端情况
        //1：完全有序[1,2,3,..,n]，差有1个不同整数
        //2: 完全无序[1,n,2,n-1...]，差有n-1个不同整数
        //[1,k+1,2,k...k/2,k/2+1]，前k+1个无序构造k个差值
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1, gap = k; i <= k; i++, gap--) {
            if (i % 2 == 0) {
                res[i] = res[i - 1] - gap;
            } else {
                res[i] = res[i - 1] + gap;
            }
        }
        for (int i = k + 1; i < n; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        new BeautifulArrangementII().constructArray(3, 2);
    }
}

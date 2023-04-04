package recursion;

/**
 * problems-779 https://leetcode.cn/problems/k-th-symbol-in-grammar/
 */
public class KthSymbolinGrammar {

    public int kthGrammar(int n, int k) {
        if (k == 0 || n == 0) {
            return 0;
        }
        int parent = kthGrammar(n - 1, (k + 1) / 2);
        if ((parent == 0 && k % 2 == 1) || (parent == 1 && k % 2 == 0)) {
            return 0;
        }
        return 1;
    }
}

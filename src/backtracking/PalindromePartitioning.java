package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * problems-131 https://leetcode-cn.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {

    private List<List<String>> res = new ArrayList<>();
    private char[] cs;

    public List<List<String>> partition(String s) {
        cs = s.toCharArray();
        dfs(new ArrayList<>(), 0);
        return res;
    }

    /**
     * [begin,s.length)寻找回文子串
     */
    private void dfs(List<String> cur, int begin) {
        if (begin == cs.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        //寻找[begin,end)的回文串和在[end,s.length)寻找回文子串
        for (int end = begin + 1; end <= cs.length; end++) {
            if (isPalindraome(begin, end)) {
                cur.add(String.valueOf(cs, begin, end - begin));
                dfs(cur, end);
                cur.remove(cur.size() - 1);
            }
        }
    }

    /**
     * [begin,end)是否回文串
     */
    private boolean isPalindraome(int begin, int end) {
        end--;
        while (begin < end) {
            if (cs[begin++] != cs[end--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new PalindromePartitioning().partition("aab");
    }
}

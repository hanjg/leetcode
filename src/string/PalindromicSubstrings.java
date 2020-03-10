package string;

/**
 * problems-647 https://leetcode-cn.com/problems/palindromic-substrings/
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        char[] cs = s.toCharArray();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPal(i, i, cs);
            count += countPal(i, i + 1, cs);
        }
        return count;
    }

    /**
     * 以[begin,end]为中心的回文子串数量
     */
    private int countPal(int begin, int end, char[] cs) {
        int count = 0;
        while (begin >= 0 && end < cs.length && cs[begin] == cs[end]) {
            count++;
            begin--;
            end++;
        }
        return count;
    }
}

package twoPointer;

/**
 * problems-76 https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        String res = null;
        //需要在s中找到的字符统计
        int[] mark = new int[128];
        for (char c : t.toCharArray()) {
            mark[c]++;
        }
        //需要在s中找到的字符计数
        int need = 0;
        for (int count : mark) {
            if (count > 0) {
                need++;
            }
        }
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            char cr = s.charAt(r);
            r++;
            mark[cr]--;
            if (mark[cr] == 0) {
                need--;
            }
            //求最短窗口，满足时缩小
            while (need <= 0) {
                res = generateResult(s, l, r, res);
                char cl = s.charAt(l);
                mark[cl]++;
                l++;
                if (mark[cl] == 1) {
                    need++;
                }
            }
        }
        return res == null ? "" : res;
    }

    private String generateResult(String s, int l, int r, String res) {
        if (res == null) {
            return s.substring(l, r);
        }
        if (r - l < res.length()) {
            return s.substring(l, r);
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring sol = new MinimumWindowSubstring();
        System.out.println(sol.minWindow("aa", "aa"));

    }

}

package twoPointer;

/**
 * problems-3 https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int res = Integer.MIN_VALUE;
        //记录[l,r)中是否出现过对字符
        int[] mark = new int[128];
        while (r < s.length()) {
            char rightChar = s.charAt(r);
            //右端点加入窗口
            mark[rightChar]++;
            r++;
            //窗口不满足条件：由于右端点加入窗口开始有重复子串，左端点移除窗口
            while (mark[rightChar] > 1) {
                mark[s.charAt(l)]--;
                l++;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().
                lengthOfLongestSubstring("abcabcbb"));
    }
}

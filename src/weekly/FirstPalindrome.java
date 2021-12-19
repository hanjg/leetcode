package weekly;

/**
 * https://leetcode-cn.com/contest/weekly-contest-272/problems/find-first-palindromic-string-in-the-array/
 */
public class FirstPalindrome {

    public String firstPalindrome(String[] words) {
        for (String s : words) {
            if (isPalindorome(s)) {
                return s;
            }
        }
        return "";
    }

    private boolean isPalindorome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i++;
            j--;
        }
        return i >= j;
    }
}

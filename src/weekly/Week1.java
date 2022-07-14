package weekly;

/**
 * @author anxi
 * @version 2022/5/8 10:44
 */
public class Week1 {

    public int rearrangeCharacters(String s, String target) {
        int[] src = new int[26];
        for (char c : s.toCharArray()) {
            src[c - 'a']++;
        }
        int[] tar = new int[26];
        for (char c : target.toCharArray()) {
            tar[c - 'a']++;
        }
        int res = 1;
        for (char c = 'a'; c <= 'z'; c++) {
            if (tar[c - 'a'] > src[c - 'a']) {
                return 0;
            }
            res *= cmn(tar[c - 'a'], src[c - 'a']);
        }
        return res;
    }

    private int cmn(int m, int n) {
        int sum1 = 1;
        for (int i = 1; i <= m; i++) {
            sum1 = sum1 * i;
        }
        int sum2 = 1;
        for (int j = n; j >= n - m + 1; j--) {
            sum2 = sum2 * j;
        }
        return sum2 / sum1;
    }

    public static void main(String[] args) {
        System.out.println(new Week1().rearrangeCharacters("ilovecodingonleetcode", "code"));
    }
}

package dp;

/**
 * problems-2266 https://leetcode.cn/problems/count-number-of-texts/
 */
public class CountNumberofTexts {

    //数字代表3个字母，相同字母子串长度->组合方式
    private long[] count3;
    //数字代表4个字母，相同字母子串长度->组合方式
    private long[] count4;
    private int mod = (int) (1e9 + 7);

    public int countTexts(String pressedKeys) {
        init();
        long res = 1;
        char pre = 'i';
        int len = 0;
        for (int i = 0; i < pressedKeys.length(); i++) {
            char cur = pressedKeys.charAt(i);
            if (cur != pre) {
                res = res * subCount(pre, len) % mod;
                pre = cur;
                len = 1;
            } else {
                len++;
            }
        }
        res = res * subCount(pre, len) % mod;
        return (int) res;
    }

    private long subCount(char c, int len) {
        if (c == '7' || c == '9') {
            return count4[len];
        }
        return count3[len];
    }

    private void init() {
        //dp[i]:子串长度i的组合个数
        long[] dp = new long[(int) 1e5 + 1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            //最后一个字母按1,2,3次
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            dp[i] %= mod;
        }
        count3 = dp;

        dp = new long[(int) 1e5 + 1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < dp.length; i++) {
            //最后一个字母按1,2,3,4次
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
            dp[i] %= mod;
        }
        count4 = dp;
    }

    public static void main(String[] args) {
        System.out.println(new CountNumberofTexts().countTexts(
                "88888888888888888888888888888999999999999999999999999999994444444444444444444444444444488888888888888888888888888888555555555555555555555555555556666666666666666666666666666666666666666666666666666666666222222222222222222222222222226666666666666666666666666666699999999999999999999999999999888888888888888888888888888885555555555555555555555555555577777777777777777777777777777444444444444444444444444444444444444444444444444444444444433333333333333333333333333333555555555555555555555555555556666666666666666666666666666644444444444444444444444444444999999999999999999999999999996666666666666666666666666666655555555555555555555555555555444444444444444444444444444448888888888888888888888888888855555555555555555555555555555555555555555555555555555555555555555555555555555555555999999999999999555555555555555555555555555554444444444444444444444444444444555"));
    }
}

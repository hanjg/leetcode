package dp;

public class DecodeWays {

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];//[0,i)的最大组合数:前i个字符最大组合数
        dp[0] = dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') {
                    dp[i] = dp[i - 2];
                } else {
                    dp[i] = 0;
                }
            } else if (s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '6') {
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') {
                    dp[i] = dp[i - 2] + dp[i - 1];
                } else {
                    dp[i] = dp[i - 1];
                }
            } else {
                if (s.charAt(i - 2) == '1') {
                    dp[i] = dp[i - 2] + dp[i - 1];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[s.length()];
    }

    public int numDecodings2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        //dp[i]:s[0,i-1]的解法数
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            char c1 = s.charAt(i-2);
            char c2 =s.charAt(i-1);
            if (c2=='0'){

            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings2("227"));
    }
}

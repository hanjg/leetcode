package math;

/**
 * problems-43 https://leetcode-cn.com/problems/multiply-strings/
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        //存储最终结果每一位的值，m*n最多m+n位
        int[] res = new int[m + n];
        //num1[i]*num2[j]的结果储存在res[i+j,i+j+1]中
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = res[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[i + j + 1] = mul % 10;
                res[i + j] += mul / 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            //去除开头的0
            if (res[i] == 0 && builder.length() == 0) {
                continue;
            }
            builder.append(res[i]);
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }

}

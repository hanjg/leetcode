package stack;

/**
 * problems-227 https://leetcode-cn.com/problems/basic-calculator-ii/
 */
public class BasicCalculatorII {

    public int calculate(String s) {
        s = s.replace(" ", "");
        int res = 0;
        //缓存的符号和绝对值
        int cacheSign = 1;
        int cacheAbs = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+') {
                res += cacheSign * cacheAbs;
                cacheSign = 1;
            } else if (c == '-') {
                res += cacheSign * cacheAbs;
                cacheSign = -1;
            } else if (c == '*') {
                int temp = 0;
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    temp = 10 * temp + s.charAt(++i) - '0';
                }
                cacheAbs *= temp;
            } else if (c == '/') {
                int temp = 0;
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    temp = 10 * temp + s.charAt(++i) - '0';
                }
                cacheAbs /= temp;
            } else {
                //number
                cacheAbs = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    cacheAbs = 10 * cacheAbs + s.charAt(++i) - '0';
                }
            }
        }
        return res + cacheSign * cacheAbs;
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculatorII().calculate(" 3+5 / 2 "));
    }
}

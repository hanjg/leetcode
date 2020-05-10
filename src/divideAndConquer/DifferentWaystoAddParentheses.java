package divideAndConquer;

import java.util.*;

/**
 * problems-241 https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
 */
public class DifferentWaystoAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            return Collections.singletonList(Integer.valueOf(input));
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') {
                            res.add(l + r);
                        } else if (c == '-') {
                            res.add(l - r);
                        } else if (c == '*') {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        return res;
    }

}

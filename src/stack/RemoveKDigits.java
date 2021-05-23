package stack;

import java.util.Stack;

/**
 * problems-402 https://leetcode-cn.com/problems/remove-k-digits/
 */
public class RemoveKDigits {

    /**
     * 单调非递减栈，保证靠前的数字尽量小
     */
    public String removeKdigits(String num, int k) {
        if (num.length() == 0 || k == 0) {
            return num;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
                //较大的元素删除
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder builder = new StringBuilder();
        int i = 0;
        //过滤开头的0
        while (i < stack.size() && stack.get(i) == '0') {
            i++;
        }
        while (i < stack.size()) {
            builder.append(stack.get(i++));
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveKDigits().removeKdigits("1432219", 3));
    }

}

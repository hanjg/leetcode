package weekly;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author anxi
 * @version 2022/5/8 10:45
 */
public class Week3 {

    public int totalSteps(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                res = Math.max(res, i - stack.pop() - 1);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Week3().totalSteps(new int[]{10,1,2,3,4,5,6,1,2,3}));
    }

}

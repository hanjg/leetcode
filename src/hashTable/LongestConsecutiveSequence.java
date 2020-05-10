package hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * problems-128 https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int maxLenght = 0;
        //记录序列中的所有数
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            //从最长连续序列的第一个开始遍历
            if (set.contains(num - 1)) {
                continue;
            }
            int len = 1;
            while (set.contains(++num)) {
                len++;
            }
            maxLenght = Math.max(maxLenght, len);
        }
        return maxLenght;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}

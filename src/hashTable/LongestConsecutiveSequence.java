package hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * problems-128 https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int maxLenght = 0;
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        //从连续序列第一个开始计算长度：num-1不在集合中
        for (int num : nums) {
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

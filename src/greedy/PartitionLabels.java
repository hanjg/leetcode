package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * problems-763 https://leetcode-cn.com/problems/partition-labels/
 */
public class PartitionLabels {

    /**
     * 从字符第一次到最后一次出现，更新当前的最小区间
     */
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, -1);
        for (int i = S.length() - 1; i >= 0; i--) {
            if (lastIndex[S.charAt(i) - 'a'] == -1) {
                lastIndex[S.charAt(i) - 'a'] = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        while (end < S.length()) {
            for (int i = start; i <= end; i++) {
                char c = S.charAt(i);
                if (lastIndex[c - 'a'] > end) {
                    end = lastIndex[c - 'a'];
                }
            }
            result.add(end - start + 1);
            start = end + 1;
            end = start;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }
}

package binarySearch;

import java.util.Arrays;

/**
 * problems-274 https://leetcode-cn.com/problems/h-index/
 */
public class HIndex {

    /**
     * @return h篇文章引用数>=h
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }
        return 0;
    }

}

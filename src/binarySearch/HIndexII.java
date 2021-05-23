package binarySearch;

/**
 * problems-275 https://leetcode-cn.com/problems/h-index-ii/
 */
public class HIndexII {

    public int hIndex(int[] citations) {
        //寻找引用数citations[i]>=n-i的i左边界：[i,n)共n-i篇文章引用数都>=n-i
        int n = citations.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (citations[m] < n - m) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return citations[l] >= n - l ? n - l : 0;
    }

}

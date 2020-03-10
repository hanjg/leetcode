package binarySearch;

/**
 * problems-153 https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimuminRotatedSortedArray {

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (m > 0 && nums[m - 1] > nums[m]) {
                return nums[m];
            }
            if (nums[m] > nums[r]) {
                //m在左半边
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        System.out.println(new FindMinimuminRotatedSortedArray().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}

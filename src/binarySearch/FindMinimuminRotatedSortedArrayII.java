package binarySearch;

/**
 * problems-154 https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinimuminRotatedSortedArrayII {

    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] > nums[r]) {
                //mid在左侧，r在右侧
                l = mid + 1;
            } else if (nums[mid] < nums[r]) {
                //mid,r都在右侧
                r = mid;
            } else {
                //1.mid和r在两侧；2.mid,r都在右侧
                r--;
            }

        }
        return nums[l];
    }


}

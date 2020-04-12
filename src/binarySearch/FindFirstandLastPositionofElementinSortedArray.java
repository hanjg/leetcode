package binarySearch;

/**
 * problems-34 https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstandLastPositionofElementinSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }

    /**
     * 寻找左边界
     */
    private int findFirst(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            //中点偏左
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                //左端点+1
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l] == target ? l : -1;
    }

    /**
     * 寻找右边界
     */
    private int findLast(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            //中点偏右
            int m = l + (r - l + 1) / 2;
            if (nums[m] > target) {
                //右端点-1
                r = m - 1;
            } else {
                l = m;
            }
        }
        return nums[r] == target ? r : -1;
    }

    public static void main(String[] args) {
        System.out.println(
                new FindFirstandLastPositionofElementinSortedArray().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        ;
    }
}

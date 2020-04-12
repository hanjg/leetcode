package binarySearch;

/**
 * problems-162 https://leetcode-cn.com/problems/find-peak-element/
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            if (low == high) {
                return low;
            }
            int mid = low + (high - low) / 2;
            if (nums[mid]==nums[mid])
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPeakElement solution = new FindPeakElement();
        int[] nums = {1, 2, 3, 1};
        System.out.println(solution.findPeakElement(nums));
    }

}

package binarySearch;


/**
 * problems-540 https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 */
public class SingleElementinaSortedArray {

    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            //l,m,r均为偶数，则目标在[l,m]或者[m,r]
            int m = (l + (r - l) / 2) / 2 * 2;
            if (nums[m] == nums[m + 1]) {
                //目标在[m+2,r]
                l = m + 2;
            } else {
                //目标在[l,m]
                r = m;
            }
        }
        return nums[l];
    }
}

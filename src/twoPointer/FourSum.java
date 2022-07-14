package twoPointer;

import java.util.*;

/**
 * problems-18 https://leetcode.cn/problems/4sum/
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i + 3 < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j + 2 < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                long subTarget = (long) target - nums[i] - nums[j];
                int left = j + 1, right = n - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == subTarget) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right - 1] == nums[right]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < subTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        System.out.println(fourSum.fourSum(nums, -294967296));
    }

}

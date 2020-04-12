package twoPointer;

/**
 * problems-75 https://leetcode-cn.com/problems/sort-colors/
 */
public class SortColors {

    public void sortColors(int[] nums) {
        // 0:[0,p1), 1:[p1,p2), 2:[p2,len)
        int p1 = 0;
        int p2 = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (p1 <= i && i < p2 && nums[i] != 1) {
                if (nums[i] == 0) {
                    swap(nums, p1, i);
                    p1++;
                } else if (nums[i] == 2) {
                    p2--;
                    swap(nums, i, p2);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = {1, 2, 0};
        sortColors.sortColors(nums);
    }
}

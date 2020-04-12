package array;

import java.util.Arrays;
import java.util.Random;

/**
 * problems-384 https://leetcode-cn.com/problems/shuffle-an-array/
 */
public class ShuffleAnArray {

    private Random random = new Random();
    private int[] backup;
    private int[] nums;

    public ShuffleAnArray(int[] nums) {
        this.backup = Arrays.copyOf(nums, nums.length);
        this.nums = nums;
    }

    public int[] reset() {
        return Arrays.copyOf(backup, backup.length);
    }

    public int[] shuffle() {
        //通过交换[i,len)随机的位置的数洗牌
        for (int i = 0; i < nums.length; i++) {
            swap(nums, i, random.nextInt(nums.length - i) + i);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ShuffleAnArray test = new ShuffleAnArray(nums);
        System.out.println(Arrays.asList(test.shuffle()));
        System.out.println(Arrays.asList(test.reset()));
        System.out.println(Arrays.asList(test.shuffle()));
    }
}

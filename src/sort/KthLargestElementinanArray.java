package sort;

/**
 * problems-215 https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementinanArray {

    public int findKthLargest(int[] nums, int k) {//快速选择
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int low, int high, int kth) {
        //分割点下标
        int pivotIndex = pivot(nums, low, high);
        if (pivotIndex == kth - 1) {
            return nums[pivotIndex];
        } else if (pivotIndex > kth - 1) {
            return quickSelect(nums, low, pivotIndex - 1, kth);
        } else {
            return quickSelect(nums, pivotIndex + 1, high, kth);
        }
    }

    private int pivot(int[] nums, int begin, int end) {
        int pivot = nums[end];
        int i = begin - 1;
        int j = end;
        //nums[<=i]: >= pivot
        //nums[>=j]: <= pivot
        while (i < j) {
            while (nums[++i] > pivot) {
                //i右移，移过>pivot的元素，停在<=pivot元素
            }
            while (i < j && nums[--j] < pivot) {
                //j左移，移过<pivot的元素，停在>=pivot元素
            }
            if (i < j) {
                // <=pivot的数和>=pivot的数交换，保证i,j左右大小
                swap(nums, i, j);
            }
        }
        //i停在<=pivot的元素，交换a[i]和pivot
        swap(nums, i, end);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        KthLargestElementinanArray test = new KthLargestElementinanArray();
        System.out.println(test.findKthLargest(nums, 2));
    }

}

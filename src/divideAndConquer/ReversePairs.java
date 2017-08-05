package divideAndConquer;

public class ReversePairs {
	private int[] temp;
	
    public int reversePairs(int[] nums) {
    	temp = new int[nums.length];
        return merge(0, nums.length - 1, nums);
    }
    
    private int merge(int start, int end, int[] nums) {
		if (start >= end) {
			return 0;
		}
		int mid = (start + end) / 2;
		int count = 0;
		count += merge(start, mid, nums) + merge(mid + 1, end, nums);
		for (int i = start, j = mid + 1; i <= mid; i++) {
			while (j <= end && nums[i] / 2.0 > nums[j]) {
				j++;
			}
			count += j -1 - mid;
		}
//		for (int i = start; i <= mid; i++) {
//			System.out.print(nums[i]);
//		}
//		System.out.print(";");
//		for (int i = mid + 1; i <= end; i++) {
//			System.out.print(nums[i]);
//		}
//		System.out.println("\tstart" + start + "end" + end + "count" + count);
		for(int i = start; i <= end; i++) {
			temp[i] = nums[i];
		}
		int i = start;
		int j = mid + 1;
		int k = start;
		while (i <= mid && j <= end) {
			if (temp[i] < temp[j]) {
				nums[k++] = temp[i++];
			} else {
				nums[k++] = temp[j++];
			}
		}
		while (i <= mid) {
			nums[k++] = temp[i++];
		}
		while (j <= end) {
			nums[k++] = temp[j++];
		}
		
		return count;
	}
    
}

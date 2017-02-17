package binarySearch;


public class FindPeakElement {//nums相邻两个数不相等
	public int findPeakElement(int[] nums){//n
		if (nums.length==1) {
			return 0;
		}
		if (nums[0]>nums[1]) {
			return 0;
		}
		if (nums[nums.length-1]>nums[nums.length-2]) {
			return nums.length-1;
		}
		else {
			for(int i=1;i<nums.length-1;i++){
				if (nums[i-1]<nums[i]&&nums[i]>nums[i+1]) {
					return i;
				}
			}
			if (nums[0]>nums[1]) {
				return 0;
			}
			if (nums[nums.length-1]>nums[nums.length-2]) {
				return nums.length-1;
			}
		}
		return -1;
	}
	
	public int findPeakElement2(int[] nums){//n
		if (nums.length==1) {
			return 0;
		}
		for(int i=1;i<nums.length;i++){
			if (nums[i-1]>nums[i]) {
				return i-1;
			}
		}
		return nums.length-1;
	}
	
	public int findPeakElement3(int[] nums){//lbn
		int low=0;
		int high=nums.length-1;
		while(low<=high){//峰在[low,high]
			if (low==high) {
				return low;
			}
			int mid=(low+high)/2;
			if (nums[mid]<nums[mid+1]) {
				low=mid+1;
			}
			else {
				high=mid;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		FindPeakElement solution=new FindPeakElement();
		int[] nums={1,2,3,1};
		System.out.println(solution.findPeakElement(nums));
	}

}

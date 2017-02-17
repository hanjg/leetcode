package binarySearch;

public class SearchforaRange {
	public int[] searchRange(int[] nums, int target) {
		int begin=0,end=nums.length-1;
		int[] res=new int[2];
		while(begin<end){//寻找左边界
			int mid=(begin+end)/2;//中点偏左
			if(nums[mid]<target)begin=mid+1;
			else end=mid;
		}
		if(nums[begin]!=target)return new int[]{-1,-1};
		res[0]=begin;
		end=nums.length-1;
		while(begin<end){//寻找右边界
			int mid=(begin+end+1)/2;//中点偏右
			if(nums[mid]>target)end=mid-1;
			else begin=mid;
		}
		res[1]=end;
		return res;
	}


}

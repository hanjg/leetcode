package binarySearch;

import java.util.TreeSet;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	if (nums.length==0||k<1||t<0) {
			return false;
		}
        TreeSet<Integer>window=new TreeSet<>();//用一个长度为k的window存放需要查找的数(下标差k)
        for(int i=0;i<nums.length;i++){
        	/*SortedSet<Long> sub=window.subSet((long)nums[i]-t, 
        			(long)nums[i]+t+1);//subset[)
        	if (!sub.isEmpty()) {
				return true;
			}
        	window.add((long)nums[i]);
        	if (i>=k) {
				window.remove((long)nums[i-k]);
			}*///子集超时
        	Integer floor=window.floor(nums[i]+t);//window中<=nums[i]+t的最大值
        	Integer ceiling=window.ceiling(nums[i]-t);//window中>=nums[i]-t的最小值
        	if ((floor!=null&&floor>=nums[i])||(ceiling!=null&&ceiling<=nums[i])) {
				return true;
			}
        	window.add(nums[i]);
        	if (i>=k) {
				window.remove(nums[i-k]);
			}
        }
        return false;
    }

	public static void main(String[] args) {
		ContainsDuplicateIII test=new ContainsDuplicateIII();
		int[] nums={-1,-1};
		System.out.println(test.containsNearbyAlmostDuplicate(nums, 1, -1));
	}

}

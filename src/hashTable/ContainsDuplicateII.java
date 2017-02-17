package hashTable;

import java.util.HashMap;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> htable=new HashMap<>();//K:数据,V数据下标
        for(int i=0;i<nums.length;i++){
        	if(htable.containsKey(nums[i])){
        		if (i-htable.get(nums[i])<=k) {
					return true;
				}
				htable.remove(nums[i]);
        	}
			htable.put(nums[i], i);
        }
        return false;
    }

	public static void main(String[] args) {
		ContainsDuplicateII test=new ContainsDuplicateII();
		int[] nums={-1,-1};
		System.out.println(test.containsNearbyDuplicate(nums, 1));
	}

}

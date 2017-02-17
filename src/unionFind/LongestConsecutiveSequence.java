package unionFind;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int max=0;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++) set.add(nums[i]);
        
        for(int i=0;i<nums.length;i++){//查找nums[i]周围的元素,存在则删除该元素并且继续查找
        	if (set.remove(nums[i])) {
				int count=1;
				int val=nums[i];
				while(set.remove(++val)) count++;
				val=nums[i];
				while(set.remove(--val))count++;
				max=Math.max(count, max);
			}
        }
        return max;
    }

}

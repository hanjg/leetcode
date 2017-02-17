package greedy;
;

public class PatchingArray {
    public int minPatches(int[] nums, int n) {
    	long miss=1;//能表示的数为[1,n)
    	int count=0,i=0;
    	while(miss<=n){
    		if(i<nums.length&&nums[i]<=miss)miss+=nums[i++];
    		else {
				miss*=2;//加入一个为miss的数字
				count++;
			}
    	}
    	return count;
    }
}

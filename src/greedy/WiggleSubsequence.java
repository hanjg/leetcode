package greedy;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
    	if (nums.length==0) {
			return 0;
		}
    	int countUp=1;//以与前面差值为正的数结尾的长度
    	int countDown=1;
    	for(int i=1;i<nums.length;i++){
    		if (nums[i]>nums[i-1]) {//只有当之前一个数是countDown处的时候,countUp增加
				countUp=countDown+1;
			}
    		else if (nums[i]<nums[i-1]) {
				countDown=countUp+1;
			}
    	}
    	return Math.max(countDown, countUp);
    }

}

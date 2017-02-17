package greedy;


public class JumpGame {
    public boolean canJump2(int[] nums) {
    	if(nums.length==0)return false;
    	int cur=1,reach=nums[0];//reach为最远可以到达的下标
    	while(reach<nums.length-1&&cur<=reach){
    		reach=Math.max(reach, cur+nums[cur]);cur++;
    	}
    	return reach>=nums.length-1;
    }

}

package greedy;

public class JumpGameII {
    public int jump(int[] nums) {
    	if(nums.length==1)return 0;
    	int cur=0,count=0;
    	while(cur+nums[cur]<nums.length-1){//从cur向后最远可以到达的下标<终点
    		int next=0,far=0;//下一跳的下标next，从next处后一步最远可以到达的下标
    		for(int i=cur+1;i<=cur+nums[cur];i++){
    			if (i+nums[i]>far) {
					next=i;far=next+nums[next];
				}
    		}
    		cur=next;count++;
    	}
    	return ++count;
    }

}

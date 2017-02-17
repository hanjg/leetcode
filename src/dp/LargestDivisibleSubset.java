package dp;
import java.util.*;
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int n=nums.length;if(n==0)return res;
        int[] dp=new int[n];//以i结尾的最大子集长度
        dp[0]=1;
        int[] pre=new int[n];//同子集中nums[i]前一个元素的下标
        Arrays.fill(pre, -1);
        Arrays.sort(nums);
        for(int i=1;i<n;i++){
        	for(int j=0;j<i;j++ ){
        		if(nums[i]%nums[j]==0){
        			if(dp[j]+1>dp[i]){
        				dp[i]=dp[j]+1;pre[i]=j;
        			}
        		}
        	}
        }
        int maxlen=0,maxid=-1;
        for(int i=0;i<n;i++){
        	if (dp[i]>maxlen) {
				maxlen=dp[i];maxid=i;
			}
        }
        while(maxid!=-1){
        	res.add(nums[maxid]);maxid=pre[maxid];
        }
        return res;
    }
}

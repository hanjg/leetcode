package dp;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n==0)return 0;
        int[] dp=new int[n];//[0,i]中以i结尾的最长上升子串的长度
        dp[0]=1;
        int max=0;
        for(int i=1;i<n;i++){
        	for(int j=0;j<i;j++){
        		if(nums[j]<nums[i])dp[i]=Math.max(dp[j], dp[i]);
        		//dp[i]为j[0,i-1]中满足nums[j]<nums[i]的最大dp[j]加1
        	}
        	dp[i]++;
        	max=Math.max(max, dp[i]);
        }
        return max;
    }

	public int lengthOfLIS2(int[] nums) {
		int n=nums.length;
		if(n==0)return 0;
		int[] tail=new int[n];//tail[i]:当前长度为i+1的序列结尾最小为tail[i]
		int len=1;//当前最长序列长度
		tail[0]=nums[0];
		for(int i=1;i<n;i++){
			int begin=0,end=len-1;
			while(begin<=end){
				int mid=(begin+end)/2;
				if(tail[mid]==nums[i]){begin=mid;break;}
				else if(tail[mid]>nums[i])end=mid-1;
				else begin=mid+1;
			}
			if (begin==len) {
				tail[len++]=nums[i];
			}else {
				tail[begin]=nums[i];
			}
		}
		return len;
	}

}

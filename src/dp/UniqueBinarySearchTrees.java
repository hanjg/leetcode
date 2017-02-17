package dp;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp=new int[n+1];//dp[i]:i个结点共有dp[i]中排列方式
        //i个结点除了根节点外还有i-1个结点，可以分配在左右子树
        dp[0]=1;
        for(int i=1;i<=n;i++){
        	for(int j=0;j<i;j++){//左子树有j个结点，右子树有i-1-j个结点
        		dp[i]+=dp[j]*dp[i-1-j];
        	}
        }
        return dp[n];
    }

}

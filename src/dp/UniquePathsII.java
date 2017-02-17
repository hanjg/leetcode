package dp;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m=obstacleGrid.length;if(m==0)return 0;
    	int n=obstacleGrid[0].length;if(n==0)return 0;
    	int[][] dp=new int[m][n];
    	for(int i=0;i<m;i++){
    		if(obstacleGrid[i][0]==0) dp[i][0]=1;
    		else break;
    	}
    	for(int j=0;j<n;j++){
    		if(obstacleGrid[0][j]==0) dp[0][j]=1;
    		else break;
    	}
    	for(int i=1;i<m;i++){
    		for(int j=1;j<n;j++){
    			dp[i][j]=obstacleGrid[i][j]==0?dp[i-1][j]+dp[i][j-1]:0;
    		}
    	}
    	return dp[m-1][n-1];
    }

	public static void main(String[] args) {
		UniquePathsII test=new UniquePathsII();
		int[][] obstacleGrid={{1,0}};
		System.out.println(test.uniquePathsWithObstacles(obstacleGrid));
	}

}

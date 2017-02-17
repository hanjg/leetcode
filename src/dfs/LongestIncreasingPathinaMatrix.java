package dfs;

public class LongestIncreasingPathinaMatrix {
	int m,n;
	int[][] longest;
	int max=0;
    public int longestIncreasingPath(int[][] matrix) {
        m=matrix.length;if(m==0)return 0;
        n=matrix[0].length;if(n==0)return 0;
        longest=new int[m][n];
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		max=Math.max(max, dfs(i, j, matrix));
        	}
        }
        return max;
    }
    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    private int dfs(int i,int j,int[][] matrix){//从(i,j)最长距离
    	if(longest[i][j]!=0)return longest[i][j];
    	int res=1;
    	for(int k=0;k<dirs.length;k++){
    		int x=i+dirs[k][0],y=j+dirs[k][1];
    		if(x>=0&&x<m&&y>=0&&y<n&&matrix[x][y]>matrix[i][j])
    			res=Math.max(res, 1+dfs(x, y, matrix));
    	}
    	longest[i][j]=res;
    	return res;
    }
}

package dp;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
    	if(matrix.length==0) return 0;
    	int m=matrix.length,n=matrix[0].length;
        int[][] edges=new int[m][n];//以(i,j)为右下角的正方形的边长
        int max=0;
        for(int i=0;i<m;i++) {
        	edges[i][0]=matrix[i][0]=='1'?1:0;
        	if(edges[i][0]==1) max=1;
        }
        for(int j=1;j<n;j++) {
        	edges[0][j]=matrix[0][j]=='1'?1:0;
        	if(edges[0][j]==1) max=1;
        }
        for(int i=1;i<m;i++){
        	for(int j=1;j<n;j++){
        		if (matrix[i][j]=='0') {
					edges[i][j]=0;
				}
        		else {
        			edges[i][j]=Math.min(Math.min(edges[i-1][j-1], edges[i][j-1]), edges[i-1][j])+1;
				}
        		if(edges[i][j]>max) max=edges[i][j];
        	}
        }
        return max*max;
    }


}

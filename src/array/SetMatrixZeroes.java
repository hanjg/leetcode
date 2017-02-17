package array;

import java.util.Arrays;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
    	int m=matrix.length;if(m==0)return;
    	int n=matrix[0].length;if(n==0)return;
    	int colZero=1;//记录第0列的状态；
    	//matrix[0][j](j>0)记录第j列的状态；matrix[i][0]记录第i行的状态；
    	for(int i=0;i<m;i++){
    		if(matrix[i][0]==0) colZero=0;
    		for(int j=1;j<n;j++){
    			if (matrix[i][j]==0) {
					matrix[i][0]=matrix[0][j]=0;
				}
    		}
    	}
    	for(int i=m-1;i>=0;i--){
    		for(int j=n-1;j>=1;j--){
    			if(matrix[0][j]==0||matrix[i][0]==0) matrix[i][j]=0;
    		}
    		if(colZero==0||matrix[i][0]==0) matrix[i][0]=0;
    	}
    	System.out.println(Arrays.toString(matrix[0]));
    }
    public static void main(String[] args) {
		new SetMatrixZeroes().setZeroes(new int[][]{{0,1}});
	}
}

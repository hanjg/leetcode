package binarySearch;

public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0)return false;
        int m=matrix.length,n=matrix[0].length;
        int i=0,j=n-1;//从右上角开始
        while(i<m&&j>=0){
        	if(target==matrix[i][j])return true;
        	else if(target>matrix[i][j])i++;
        	else j--;
        }
        return false;
    }

}

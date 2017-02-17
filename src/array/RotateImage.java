package array;

public class RotateImage {
    public void rotate(int[][] matrix) {//先关于x轴对称变换再转置(转置相当于关于y=x对称变换)
	    int n=matrix.length;
	    if(n==0||n==1)return;
	    for(int i=0;i<n/2;i++){
	    	for(int j=0;j<n;j++){
	    		int temp=matrix[i][j];matrix[i][j]=matrix[n-1-i][j];matrix[n-1-i][j]=temp;
	    	}
	    }
	    for(int i=0;i<n;i++){
	    	for(int j=0;j<i;j++){
	    		int temp=matrix[i][j];matrix[i][j]=matrix[j][i];matrix[j][i]=temp;
	    	}
	    }
	}

	public void rotate2(int[][] matrix) {//交换一组中的4个点
        int n=matrix.length;
        if(n==0||n==1)return;
        for(int i=0;i<(n+1)/2;i++){
        	for(int j=0;j<n/2;j++){
        		int t=matrix[i][j];
        		matrix[i][j]=matrix[n-1-j][i];
        		matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
        		matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
        		matrix[j][n-1-i]=t;
        	}
        }
    }

}

package array;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
    	int[][] res=new int[n][n];
    	int num=1,rowbegin=0,rowend=n,colbegin=0,colend=n;//范围[rowbegin,rowend),[colbegin,colend)
    	while(rowbegin<rowend&&colbegin<colend){
    		for(int j=colbegin;j<colend;j++)res[colbegin][j]=num++;
    		rowbegin++;
    		for(int i=rowbegin;i<rowend;i++) res[i][colend-1]=num++;
    		colend--;
    		if (rowbegin<rowend) {
				for(int j=colend-1;j>=colbegin;j--) res[rowend-1][j]=num++;
				rowend--;
			}
    		if (colbegin<colend) {
				for(int i=rowend-1;i>=rowbegin;i--) res[i][colbegin]=num++;
				colbegin++;
			}
    	}
    	return res;
    }
    public static void main(String[] args) {
		new SpiralMatrixII().generateMatrix(2);
	}
}

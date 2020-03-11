package backtracking;


public class NQueensII {
    boolean[] cols,dias1,dias2;//第i列,两条斜线是否已经放置皇后
    int count=0;
	public int totalNQueens(int n) {
		cols=new boolean[n];dias1=new boolean[2*n-1];dias2=new boolean[2*n-1];
		dfs(0, n);
		return count;
	}
	private void dfs(int row,int n){//放置第row行	
		if (row==n) {
			count++;return;
		}
		for(int j=0;j<n;j++){
			if (isValid(row, j, n)) {
				cols[j]=dias1[row+j]=dias2[row-j+n-1]=true;
				dfs(row+1, n);
				cols[j]=dias1[row+j]=dias2[row-j+n-1]=false;
			}
		}
	}
	private boolean isValid(int i,int j,int n){//放置在(i,j)是否合理
		return !cols[j]&&!dias1[i+j]&&!dias2[i-j+n-1];
	}
}

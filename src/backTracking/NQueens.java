package backTracking;
import java.util.*;
public class NQueens {
	List<List<String>> res;
	int[] pos;//第i行放在第j列
    public List<List<String>> solveNQueens(int n) {
    	res=new ArrayList<>();
    	pos=new int[n];
    	dfs(n, 0);
    	return res;
    }
    private void dfs(int n,int row){//在第row行放皇后
    	if (row==n) {
			List<String> solution=new ArrayList<>();
			for(int i=0;i<n;i++){
				StringBuilder builder=new StringBuilder();
				for(int j=0;j<n;j++){
					if(pos[i]==j)builder.append('Q');
					else builder.append('.');
				}
				solution.add(builder.toString());
			}
			res.add(solution);return;
		}
    	for(int col=0;col<n;col++){
    		if(isVaild(row, col)){
    			pos[row]=col;dfs(n, row+1);
    		}
    	}
    }
    private boolean isVaild(int i,int j){//放在(i,j)处是否合理
    	for(int row=0;row<i;row++){
    		if(pos[row]==j||i+j==row+pos[row]||i-j==row-pos[row]) return false;
    	}
    	return true;
    }
}

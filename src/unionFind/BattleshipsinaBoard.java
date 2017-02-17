package unionFind;

public class BattleshipsinaBoard {
	int m,n;
	boolean[][] visited;
    public int countBattleships(char[][] board) {
        m=board.length;if(m==0)return 0;
        n=board[0].length;if(n==0)return 0;
        visited=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(!visited[i][j]&&board[i][j]=='X'){
        			dfs(board, i, j);count++;
        		}
        	}
        }
        return count;
    }
    private void dfs(char[][] board,int i,int j){
    	if(i<0||i>=m||j<0||j>=n||visited[i][j]||board[i][j]=='.')return;
    	visited[i][j]=true;
    	dfs(board, i+1, j);
    	dfs(board, i-1, j);
    	dfs(board, i, j+1);
    	dfs(board, i, j-1);
    }
}

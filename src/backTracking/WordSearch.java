package backTracking;

public class WordSearch {
	int m,n;
	char[] cword;
    public boolean exist(char[][] board, String word) {
    	m=board.length;if(m==0)return false;
    	n=board[0].length;if(n==0)return false;
    	cword=word.toCharArray();
    	for(int i=0;i<m;i++){
    		for(int j=0;j<n;j++){
    			if(dfs(board, i, j, 0)) return true;
    		}
    	}
    	return false;
    }
    
    private boolean dfs(char[][] board,int i,int j,int begin){//从(i,j)开始搜索cword[begin]
    	if(begin==cword.length) return true;
    	if(i<0||i==m||j<0||j==n||board[i][j]!=cword[begin]) return false;
    	char c=board[i][j];
    	board[i][j]='#';
    	if (dfs(board, i-1, j, begin+1)||dfs(board, i+1, j, begin+1)||
    			dfs(board, i, j+1, begin+1)||dfs(board, i, j-1, begin+1)) {
			return true;
		}
    	board[i][j]=c;
    	return false;
    }
}

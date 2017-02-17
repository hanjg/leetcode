package unionFind;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	int m,n;
    public void solve(char[][] board) {
        m=board.length;if(m<=2)return;
        n=board[0].length;if(n<=2)return;
        for(int i=0;i<m;i++){
        	bfs(board, i, 0);bfs(board, i, n-1);
        }
        for(int j=1;j<n-1;j++){
        	bfs(board, 0, j);bfs(board, m-1, j);
        }
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(board[i][j]=='U')board[i][j]='O';//用U标记(i,j)未被包围
        		else board[i][j]='X';
        	}
        }
    }
    private void bfs(char[][] board,int i,int j){
    	if(board[i][j]!='O')return;
    	int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    	Queue<Integer> queue=new LinkedList<>();
    	board[i][j]='U';queue.add(i*n+j);
    	while(!queue.isEmpty()){
    		int key=queue.poll();
    		i=key/n;j=key%n;
    		for(int k=0;k<dirs.length;k++){
    			int x=i+dirs[k][0],y=j+dirs[k][1];
    			if(x>=0&&x<m&&y>=0&&y<n&&board[x][y]=='O'){
    				board[x][y]='U';
    				queue.add(x*n+y);
    			}
    		}
    	}
    }
}

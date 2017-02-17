package array;

public class GameofLife {
    public void gameOfLife(int[][] board) {
    	//原始数据中00表示死，01表示活
        //现在0b00:死->死，0b01:活->死,0b10:死->活,0b11:活->活，这样可以记录之前的状态
    	//即00和10表示之前死,01,11表示之前活
    	if(board.length==0)return;
    	int m=board.length,n=board[0].length;
    	for(int i=0;i<m;i++){
    		for(int j=0;j<n;j++){
    			int nei=-(board[i][j]&1);//邻接的活细胞数量
    			for(int x=Math.max(0, i-1);x<=Math.min(i+1, m-1);x++){
    				for(int y=Math.max(0, j-1);y<=Math.min(j+1, n-1);y++){
    					if((board[x][y]&1)==1) nei++;
    				}
    			}
    			if(board[i][j]==0&&nei==3)board[i][j]=2;
    			if(board[i][j]==1&&(nei==2||nei==3)) board[i][j]=3;
    		}
    	}
    	for(int i=0;i<m;i++){
    		for(int j=0;j<n;j++){
    			board[i][j]=board[i][j]>>1;
    		}
    	}
    }
    public static void main(String[] args){
    	int[][] board={{1}};
    	new GameofLife().gameOfLife(board);
    }
}

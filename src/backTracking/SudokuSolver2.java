package backTracking;

public class SudokuSolver2 {
	int[] rows,cols,subs;//用int的后9个bit位记录每一行、列、子方格中出现过的数字1-9
    public void solveSudoku(char[][] board) {
    	rows=new int[9];cols=new int[9];subs=new int[9];
    	for(int i=0;i<9;i++){
    		for(int j=0;j<9;j++){
    			if(board[i][j]=='.')continue;
    			int t=1<<(board[i][j]-'1');
    			rows[i]|=t;cols[j]|=t;subs[i/3*3+j/3]|=t;
    		}
    	}
    	dfs(board, 0, 0);
    }
    private boolean dfs(char[][] board,int row,int col){
    	//从(row,col)开始填入的数字,返回是否能填满方格
    	for(int i=row;i<9;i++){
    		for(int j=i==row?col:0;j<9;j++){
    			if (board[i][j]=='.') {
					for(char put='1';put<='9';put++){
						int t=1<<(put-'1');
						if (isValid(board, i, j, t)) {
							board[i][j]=put;
							rows[i]|=t;cols[j]|=t;subs[i/3*3+j/3]|=t;
							if(j==8?dfs(board, i+1, 0):dfs(board, i, j+1))return true;
							board[i][j]='.';
							rows[i]^=t;cols[j]^=t;subs[i/3*3+j/3]^=t;
						}
					}
					return false;
				}
    		}
    	}
    	return true;
    }
    private boolean isValid(char[][] board,int i,int j,int t){//填入的数字对应的序列
    	return (rows[i]&t)==0&&(cols[j]&t)==0&&(subs[i/3*3+j/3]&t)==0;
    }
    
    public static void main(String[] args) {
		String[] strings={"53..7....","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6",".6....28.","...419..5","....8..79"};
		char[][] board=new char[9][9];
		for(int i=0;i<strings.length;i++){
			board[i]=strings[i].toCharArray();
		}
		new SudokuSolver2().solveSudoku(board);

		for(int r=0;r<9;r++){
			for(int l=0;l<9;l++){
				if(l%3==0)System.out.print("\t");
				System.out.print(board[r][l]);
			}
			System.out.println();
		}
		System.out.println("----------------");
	}
}

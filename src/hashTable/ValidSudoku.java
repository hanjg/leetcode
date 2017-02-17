package hashTable;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
    	int[] row=new int[9],col=new int[9],sub=new int[9];
    	//用int的后10个bit位记录每一行、列、子方格中出现过的数字1-9
    	for(int i=0;i<9;i++){
    		for(int j=0;j<9;j++){
    			if(board[i][j]=='.')continue;
    			int temp=1<<(board[i][j]-'1');//[i,j]表示的序列
    			if((row[i]&temp)!=0||(col[j]&temp)!=0||(sub[i/3*3+j/3]&temp)!=0)return false;
    			row[i]|=temp;col[j]|=temp;sub[i/3*3+j/3]|=temp;
    		}
    	}
    	return true;
    }

	public boolean isValidSudoku2(char[][] board) {
		boolean[][] row=new boolean[9][9],col=new boolean[9][9],sub=new boolean[9][9];
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(board[i][j]=='.')continue;
				int t=board[i][j]-'1';
				if(row[i][t]||col[j][t]||sub[i/3*3+j/3][t])return false;
				row[i][t]=col[j][t]=sub[i/3*3+j/3][t]=true;
			}
		}
		return true;
	}
}

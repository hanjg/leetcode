package dp;

public class DungeonGame {
	/*int min;
	int m;
	int n;
    public int calculateMinimumHP(int[][] dungeon) {//超时
    	m=dungeon.length;
    	n=dungeon[0].length;
    	min=1;
    	go(dungeon, 0, 0, 0, 0);
    	return 1-min;
    }
    
    private void go(int[][] dungeon,int i,int j,int min,int pre){
    	//走到(i,j)之前的血量为pre,min为走到(i,j)之前的最小血量<=0
    	int current=pre+dungeon[i][j];
    	if (i==m-1&&j==n-1) {
			min=Math.min(current, min);
			if (this.min>0||min>this.min) {
				this.min=min;
			}
			return;
		}
    	if (i<m-1) {
			go(dungeon, i+1, j, Math.min(current, min), current);
		}
    	if (j<n-1) {
			go(dungeon, i, j+1, Math.min(current, min), current);
		}
    }*/

	public int calculateMinimumHP(int[][] dungeon) {//逆向动态规划
	    int m=dungeon.length;
	    int n=dungeon[0].length;
	    int[][] minHp=new int[m][n];//从(i,j)到终点需要的最小血量
	    
	    minHp[m-1][n-1]=dungeon[m-1][n-1]>=0?1:1-dungeon[m-1][n-1];
	    for(int i=m-2;i>=0;i--){
	    	if (dungeon[i][n-1]>=minHp[i+1][n-1]) {
				minHp[i][n-1]=1;
			}
	    	else {
				minHp[i][n-1]=minHp[i+1][n-1]-dungeon[i][n-1];
			}
	    }
	    for(int j=n-2;j>=0;j--){
	    	if (dungeon[m-1][j]>=minHp[m-1][j+1]) {
				minHp[m-1][j]=1;
			}
	    	else {
				minHp[m-1][j]=minHp[m-1][j+1]-dungeon[m-1][j];
			}
	    }
	    
	    for(int i=m-2;i>=0;i--){
	    	for(int j=n-2;j>=0;j--){
	    		int lower=Math.min(minHp[i+1][j], minHp[i][j+1]);
	    		minHp[i][j]=dungeon[i][j]>=lower?1:lower-dungeon[i][j];
	    	}
	    }
	    return minHp[0][0];
	}


	public static void main(String[] args) {
		DungeonGame test=new DungeonGame();
		int[][] du={{0,-3}};

		System.out.println(test.calculateMinimumHP(du));
	}

}

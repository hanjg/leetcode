package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterII {
	class Bar{
		int x,y,height;
		Bar(int x,int y,int height){
			this.x=x;this.y=y;this.height=height;
		}
	}
	
    public int trapRainWater(int[][] heightMap) {
    	int m=heightMap.length;if(m<=2)return 0;
    	int n=heightMap[0].length;if(n<=2)return 0;
    	PriorityQueue<Bar> queue=new PriorityQueue<>(2*m+2*n,new Comparator<Bar>() {
    		public int compare(Bar bar,Bar bar2){
    			return bar.height-bar2.height;
    		}
		});//包围中央的柱子的高度
    	boolean[][] visited=new boolean[m][n];//(i,j)是否访问过
    	int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};//之后访问的方向
    	for(int i=0;i<m;i++){
    		queue.add(new Bar(i, 0, heightMap[i][0]));
    		queue.add(new Bar(i, n-1, heightMap[i][n-1]));
    		visited[i][0]=visited[i][n-1]=true;
    	}
    	for(int j=1;j<n-1;j++){
    		queue.add(new Bar(0, j, heightMap[0][j]));
    		queue.add(new Bar(m-1, j, heightMap[m-1][j]));
    		visited[0][j]=visited[m-1][j]=true;
    	}
    	int res=0;
    	while(!queue.isEmpty()){
    		Bar bar=queue.poll();
    		for(int k=0;k<dirs.length;k++){
    			int x=bar.x+dirs[k][0],y=bar.y+dirs[k][1];
    			if(x>=0&&x<m&&y>=0&&y<n&&!visited[x][y]){
    				res+=Math.max(0, bar.height-heightMap[x][y]);
    				queue.add(new Bar(x, y, Math.max(bar.height, heightMap[x][y])));
    				visited[x][y]=true;
    			}
    		}
    	}
    	return res;
    }
}

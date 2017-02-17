package stack;
import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
    	if(matrix.length==0) return 0;
    	int m=matrix.length,n=matrix[0].length;
    	int[][] histograms=new int[m][n];//his[i][j]以第i行为底边的下标为j的直方图的高度
    	for(int j=0;j<n;j++){
    		histograms[0][j]=matrix[0][j]=='1'?1:0;
    	}
    	for(int i=1;i<m;i++){
    		for(int j=0;j<n;j++){
    			histograms[i][j]=matrix[i][j]=='1'?histograms[i-1][j]+1:0;
    		}
    	}
    	int max=0;
    	for(int i=0;i<m;i++){
    		Stack<Integer> stack=new Stack<>();//存储直方图的下标
    		for(int j=0;j<=n;j++){
    			int hei=j==n?0:histograms[i][j];
    			if (stack.isEmpty()||hei>histograms[i][stack.peek()]) {
					stack.push(j);
				}
    			else {
					int temp=stack.pop();
					max=Math.max(max, histograms[i][temp]*(stack.isEmpty()?j:j-stack.peek()-1));
					j--;
				}
    		}
    	}
    	return max;
    }

	public static void main(String[] args){
		char[][] cs={"11".toCharArray()};
		System.out.println(new MaximalRectangle().maximalRectangle(cs));
	}

}

package array;
import java.util.*;
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> res=new ArrayList<>();
    	if(matrix.length==0||matrix[0].length==0)return res;
    	int rowbegin=0,rowend=matrix.length,colbegin=0,colend=matrix[0].length;
    	while(rowbegin<rowend&&colbegin<colend){
    		for(int j=colbegin;j<colend;j++) res.add(matrix[rowbegin][j]);
    		rowbegin++;
    		for(int i=rowbegin;i<rowend;i++) res.add(matrix[i][colend-1]);
    		colend--;
    		if (rowbegin<rowend) {
				for(int j=colend-1;j>=colbegin;j--) res.add(matrix[rowend-1][j]);
				rowend--;
			}
    		if(colbegin<colend){
    			for(int i=rowend-1;i>=rowbegin;i--) res.add(matrix[i][colbegin]);
    			colbegin++;
    		}
    	}
    	return res;
    }
}

package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {
	class RowMin{
		int row,col, val;
		RowMin(int row,int col,int val){
			this.row=row;this.col=col;this.val=val;
		}
	}
    public int kthSmallest(int[][] matrix, int k) {
    	if(matrix==null||matrix.length==0||k<=0) return 0;
        PriorityQueue<RowMin> queue=new PriorityQueue<>(matrix.length, new Comparator<RowMin>() {

			public int compare(RowMin o1, RowMin o2) {
				return o1.val-o2.val;
			}
		});
        for(int i=0;i<matrix.length;i++){
        	queue.add(new RowMin(i, 0, matrix[i][0]));
        }
        RowMin temp=null;
        while(k>0){
        	temp=queue.poll();
        	k--;
        	int next=temp.col+1;
        	if(next<matrix[0].length)queue.add(new RowMin(temp.row, next, matrix[temp.row][next]));
        }
        return temp.val;
    }

}

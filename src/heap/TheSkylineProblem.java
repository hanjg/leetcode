package heap;
import java.util.*;
public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {//buildings左右高
        List<int[]>res=new ArrayList<>();
        List<int[]> vertices=new ArrayList<>();//存储顶点，左顶点高度负数，右顶点高度正数
        for(int[]building:buildings){
        	vertices.add(new int[]{building[0],-building[2]});
        	vertices.add(new int[]{building[1],building[2]});
        }
        Collections.sort(vertices, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2){
				if(o1[0]==o2[0])return o1[1]-o2[1];
				else return o1[0]-o2[0];
			}
		});//x由小到大排列，y由小到大排列
        //（由于左顶点高度为负数，相同x的左顶点，高度大的在前，相同x的右顶点高度小的在前）
        PriorityQueue<Integer> heap=new PriorityQueue<>(100,
        		Collections.reverseOrder());//堆顶为当前的最大高度
        heap.add(0);
        int pre=0;//之前的keyPoint的高度
        for(int[] vertex:vertices){
        	if(vertex[1]<0)heap.add(-vertex[1]);
        	else heap.remove(vertex[1]);
        	int cur=heap.peek();//当前的最大高度
        	if(cur!=pre){
        		res.add(new int[]{vertex[0],cur});
        		pre=cur;
        	}
        }
        return res;
    }
}

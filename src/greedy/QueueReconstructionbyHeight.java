package greedy;

import java.util.*;

public class QueueReconstructionbyHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
        	public int compare(int[] p1,int[] p2){
        		if(p1[0]==p2[0])return p1[1]-p2[1];
        		else return p2[0]-p1[0];
        	}
		});//(h,k):h大的，k小的在前
        List<int[]> temp=new LinkedList<>();
        for(int i=0;i<people.length;i++){
        	temp.add(people[i][1], people[i]);//res中的人h均大于等于people[i]
        }
        int[][] res=new int[people.length][2];
        for(int i=0;i<people.length;i++){
        	res[i]=temp.get(i);
        }
        return res;
    }
}

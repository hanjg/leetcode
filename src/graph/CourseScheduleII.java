package graph;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res=new int[numCourses];int count=0;
        List<List<Integer>> sets=new ArrayList<>();//邻接表，记录弧头to
        for(int i=0;i<numCourses;i++)sets.add(new ArrayList<Integer>());
        int[] indegree=new int[numCourses];//入度
        
        for(int i=0;i<prerequisites.length;i++){
        	sets.get(prerequisites[i][1]).add(prerequisites[i][0]);
        	indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
        	if(indegree[i]==0)queue.add(i);
        }
        while(!queue.isEmpty()){
        	int cur=queue.poll();
        	res[count++]=cur;
        	List<Integer> next=sets.get(cur);
        	for(int to:next){
        		if(--indegree[to]==0)queue.add(to);
        	}
        }
        return count==numCourses?res:new int[0];
    }
}

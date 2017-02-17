package graph;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> sets=new ArrayList<>();//邻接表，记录弧头to
		for(int i=0;i<numCourses;i++)sets.add(new ArrayList<Integer>());
        int[] indegree=new int[numCourses];
        
        for(int i=0;i<prerequisites.length;i++){
        	sets.get(prerequisites[i][0]).add(prerequisites[i][1]);
        	indegree[prerequisites[i][1]]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
        	if(indegree[i]==0)queue.add(i);
        }
        int count=0;
        while(!queue.isEmpty()){
        	Integer cur=queue.poll();count++;
        	List<Integer> fromto=sets.get(cur);
        	for(int to:fromto){
        		indegree[to]--;
        		if(indegree[to]==0)queue.add(to);
        	}
        }
        return count==numCourses;
    }
}

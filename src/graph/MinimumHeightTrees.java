package graph;
import java.util.*;
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1)return Arrays.asList(0);
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<Integer>());
        int[] indegree=new int[n];
        for(int i=0;i<edges.length;i++){
        	graph.get(edges[i][0]).add(edges[i][1]);
        	graph.get(edges[i][1]).add(edges[i][0]);
        	indegree[edges[i][1]]++;indegree[edges[i][0]]++;
        }
        
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++)if(indegree[i]==1)queue.add(i);
        int left=n;
        while(left>2){
        	int amount=queue.size();
        	for(int i=0;i<amount;i++){
        		int cur=queue.poll();left--;
        		List<Integer> fromto=graph.get(cur);
        		for(int to:fromto) if(--indegree[to]==1)queue.add(to);
        	}
        }
        List<Integer> res=new ArrayList<>();
        while(!queue.isEmpty())res.add(queue.poll());
        return res;
    }
}

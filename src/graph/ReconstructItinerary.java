package graph;
import java.util.*;
public class ReconstructItinerary {
	Map<String, PriorityQueue<String>> graph;
	List<String> result;
    public List<String> findItinerary(String[][] tickets) {
        graph=new HashMap<>();
        result=new LinkedList<>();
        for(String[] pair:tickets){
        	if(!graph.containsKey(pair[0])) graph.put(pair[0], new PriorityQueue<String>());
        	graph.get(pair[0]).add(pair[1]);
        }
        dfs("JFK");
        return result;
    }
    
    private void dfs(String from){
    	PriorityQueue<String> tos=graph.get(from);
    	while(!tos.isEmpty()){
    		dfs(tos.poll());
    	}
    	result.add(0,from);
    }
    public static void main(String[] args) {
		System.out.println(new ReconstructItinerary().findItinerary(new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}}));
	}
}

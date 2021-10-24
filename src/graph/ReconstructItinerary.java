package graph;

import java.util.*;

/**
 * problems-332 https://leetcode-cn.com/problems/reconstruct-itinerary/
 */
public class ReconstructItinerary {

    private Map<String, PriorityQueue<String>> graph;
    private List<String> result;

    public List<String> findItinerary(List<List<String>> tickets) {
        graph = initGraph(tickets);
        result = new ArrayList<>(tickets.size());
        dfs("JFK");
        Collections.reverse(result);
        return result;
    }

    /**
     * from->下一个节点列表，字典排序
     */
    private Map<String, PriorityQueue<String>> initGraph(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>(tickets.size());
        for (List<String> edge : tickets) {
            String from = edge.get(0);
            String to = edge.get(1);
            if (graph.get(from) == null) {
                graph.put(from, new PriorityQueue<>());
            }
            graph.get(from).add(to);
        }
        return graph;
    }

    /**
     * 对有出边的节点递归dfs
     */
    private void dfs(String from) {
        while (graph.containsKey(from) && !graph.get(from).isEmpty()) {
            dfs(graph.get(from).poll());
        }
        result.add(from);
    }

}

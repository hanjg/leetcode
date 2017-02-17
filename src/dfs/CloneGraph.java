package dfs;
import java.util.*;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	
	UndirectedGraphNode(int x){
		label = x; 
		neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
}

public class CloneGraph {
    HashMap<UndirectedGraphNode, UndirectedGraphNode> map=new HashMap<>();//K=节点，V=副本
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	return dfs(node);
    }
    
    private UndirectedGraphNode dfs(UndirectedGraphNode node){//返回由node复制的新节点
    	if (node==null) {
			return null;
		}
    	if (map.containsKey(node)) {
			return map.get(node);
		}
    	UndirectedGraphNode newNode=new UndirectedGraphNode(node.label);
		map.put(node, newNode);
		for(int i=0;i<node.neighbors.size();i++){
			newNode.neighbors.add(dfs(node.neighbors.get(i)));
		}
    	return newNode;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

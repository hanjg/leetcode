package graph;
import java.util.*;

public class EvaluateDivision {
	HashMap<String, Map<String, Double>> vertices;//K=节点,V节点的邻接表
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        vertices=new HashMap<>();
        for(int i=0;i<equations.length;i++){
        	if (!vertices.containsKey(equations[i][0])) {
				Map<String, Double> map1=new HashMap<>();
				map1.put(equations[i][1], values[i]);
				vertices.put(equations[i][0], map1);
			}
        	else {
				Map<String, Double> map1=vertices.get(equations[i][0]);
				map1.put(equations[i][1], values[i]);
			}
        	if (!vertices.containsKey(equations[i][1])) {
				Map<String, Double> map2=new HashMap<>();
				map2.put(equations[i][0], 1/values[i]);
				vertices.put(equations[i][1], map2);
			}
        	else {
				Map<String, Double> map2=vertices.get(equations[i][1]);
				map2.put(equations[i][0], 1/values[i]);
			}
        }
        double[] result=new double[queries.length];
        for(int i=0;i<queries.length;i++){
        	if ((!vertices.containsKey(queries[i][0]))||(!vertices.containsKey(queries[i][1]))) {
				result[i]=-1.0;
			}
        	else if (queries[i][0].equals(queries[i][1])) {
					result[i]=1.0;
			}
        	else {
        		Set<String> visited=new HashSet<>();
				Double temp=dfs(1,queries[i][0],queries[i][1],visited);
				result[i]=temp==null?-1.0:temp;
			}
        }
        return result;
    }
    
    private Double dfs(double val,String begin,String end,Set<String> visited){
    	if (begin.equals(end)) {
			return val;
		}
    	visited.add(begin);
    	Map<String, Double> map=vertices.get(begin);
    	for(Map.Entry<String, Double> entry:map.entrySet()){
    		if (!visited.contains(entry.getKey())) {
				Double temp=dfs(val*entry.getValue(), entry.getKey(), end, visited);
				if (temp!=null) {
					return temp;
				}
			}
    	}
    	visited.remove(begin);
    	return null;
    }

	public static void main(String[] args) {
		String[][] equations={{"a","b"},{"b","c"}}; 
		double[] values={2.0,3.0};
		String[][] queries={{"a","c"},{"b","c"},{"a","e"},{"a","a"},{"x","x"}};
		double[] result=new EvaluateDivision().calcEquation(equations, values, queries);
		for(int i=0;i<result.length;i++){
			System.out.print(result[i]+" ");
		}
	}

}

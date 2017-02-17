package divideAndConquer;
import java.util.*;

public class DifferentWaystoAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<input.length();i++){
        	if(input.charAt(i)=='+'||input.charAt(i)=='-'||input.charAt(i)=='*'){
        		List<Integer> left=diffWaysToCompute(input.substring(0, i));
        		List<Integer> right=diffWaysToCompute(input.substring(i+1));
        		for(int j=0;j<left.size();j++){
        			for(int k=0;k<right.size();k++){
        				if(input.charAt(i)=='+')res.add(left.get(j)+right.get(k));
        				else if(input.charAt(i)=='-') res.add(left.get(j)-right.get(k));
        				else res.add(left.get(j)*right.get(k));
        			}
        		}
        	}
        }
        if(res.isEmpty()) res.add(Integer.valueOf(input));
        return res;
    }

}

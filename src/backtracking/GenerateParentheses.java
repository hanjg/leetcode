package backtracking;
import java.util.*;

public class GenerateParentheses {
	List<String>result;
    public List<String> generateParenthesis(int n) {
        result=new ArrayList<>();
        dfs(n, n, "");
        return result;
    }
    private void dfs(int l,int r,String cache){
    	//l,r左右括号还剩下来的个数
    	if(l==0&&r==0){
    		result.add(cache);return;
    	}
    	if(l>0)dfs(l-1, r, cache+"(");
    	if(r>0&&l<r)dfs(l, r-1, cache+")");
    }
	
    
    public static void main(String[] args) {
		GenerateParentheses bk=new GenerateParentheses();
		System.out.println(bk.generateParenthesis(3));
	}

}

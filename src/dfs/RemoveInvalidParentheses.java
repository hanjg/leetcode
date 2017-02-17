package dfs;
import java.util.*;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> result=new HashSet<>();
        int rmL=0,rmR=0;//需要移除的括号数量，即未匹配的左右括号数量
        for(int i=0;i<s.length();i++){//得到s中的rmL,rmR
        	if (s.charAt(i)=='(') {
				rmL++;
			}
        	else if (s.charAt(i)==')') {
				if (rmL!=0) {
					rmL--;
				}
				else {
					rmR++;
				}
			}
        }
        dfs(result, s, rmL, rmR, 0, new StringBuilder(""), 0);
        return new ArrayList<>(result);
    }
    
    private void dfs(Set<String> result,String s,int rmL,int rmR,int i,
    		StringBuilder comb,int count){
    //rmL,rmR为s中还需要移除的左右括号,i为现在正在访问的s中字符的下标，count为comb中左括号数-右括号数 
    	if (i==s.length()) {
    		if (rmL==0&&rmR==0&&count==0) {
				result.add(comb.toString());
			}
    		return;
    	}
    	char c=s.charAt(i);
    	int preLength=comb.length();
    	if (c=='(') {
			if (rmL>0) {
				dfs(result, s, rmL-1, rmR, i+1, comb, count);//删除'('
			}
			dfs(result, s, rmL, rmR, i+1, comb.append(c), count+1);//保留'('
		}
    	else if (c==')') {
			if (rmR>0) {
				dfs(result, s, rmL, rmR-1, i+1, comb, count);//删除)
			}
			if (count>0) {
				dfs(result, s, rmL, rmR, i+1, comb.append(c), count-1);//保留)
			}
		}
    	else {
			dfs(result, s, rmL, rmR, i+1, comb.append(c), count);
		}
    	comb.setLength(preLength);
    	
    }
	public static void main(String[] args) {
		RemoveInvalidParentheses test=new RemoveInvalidParentheses();
		System.out.println(test.removeInvalidParentheses("()())()"));
	}

}

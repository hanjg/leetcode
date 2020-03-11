package backtracking;
import java.util.*;
public class RestoreIPAddresses {
	List<String> result;
    public List<String> restoreIpAddresses(String s) {
        result=new ArrayList<>();
        dfs(s, 0, new ArrayList<String>());
        return result;
    }
    private void dfs(String s,int begin,List<String> list){
    	if(list.size()==4){
    		if(begin==s.length()){
    			StringBuilder builder=new StringBuilder();
    			for(int i=0;i<3;i++){
    				builder.append(list.get(i));builder.append(".");
    			}
    			builder.append(list.get(3));
    			result.add(builder.toString());
    		}
    		return;
    	}
    	for(int i=1;i<4&&begin+i<=s.length();i++){
    		String temp=s.substring(begin,begin+i);
    		if(isValid(temp)){
    			list.add(temp);dfs(s, begin+i, list);list.remove(list.size()-1);
    		}
    	}
    }
    private boolean isValid(String string){
    	int val=Integer.valueOf(string);
    	if(val>255)return false;
    	return String.valueOf(val).length()==string.length();
    }
}

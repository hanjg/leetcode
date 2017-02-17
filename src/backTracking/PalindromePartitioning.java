package backTracking;
import java.util.*;
public class PalindromePartitioning {
	List<List<String>>res;
	char[] cs;
    public List<List<String>> partition(String s) {
        res=new ArrayList<>();
        cs=s.toCharArray();
        dfs(0, new ArrayList<String>());
        return res;
    }
    private void dfs(int begin,List<String> cur){
    	//从s的begin处开始寻找回文[begin,cut)
    	if(begin==cs.length){
    		res.add(new ArrayList<>(cur));return;
    	}
    	for(int cut=begin+1;cut<=cs.length;cut++){
    		if(isPal(begin, cut)){
    			cur.add(new String(cs, begin, cut-begin));
    			dfs(cut, cur);
    			cur.remove(cur.size()-1);
    		}
    	}
    }
    private boolean isPal(int l,int r){//[l,r)是否回文
    	r--;
    	while(l<r)if(cs[l++]!=cs[r--])return false;
    	return true;
    }
}

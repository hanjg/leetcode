package backtracking;
import java.util.*;
public class WordBreakII {
	HashMap<String, List<String>> map;//string+string对应dict中的组合的列表
    public List<String> wordBreak(String s, Set<String> wordDict) {
    	map=new HashMap<>();
    	return dfs(s, wordDict);
    }
    
    private List<String> dfs(String s,Set<String>wordDict){//返回s在dict中对应组合列表即res
    	if(map.containsKey(s))return map.get(s);
    	List<String> res=new ArrayList<>();
    	if(s.equals("")){
    		res.add(null);return res;
    	}
    	for(String word:wordDict){
    		if(s.startsWith(word)){
    			List<String>list =dfs(s.substring(word.length()), wordDict);//word+list=result
    			for(String sub:list){
    				res.add(word+(sub==null?"":(" "+sub)));
    			}
    		}
    	}
    	map.put(s, res);
    	return res;
    }
    
    public static void main(String[] args){
    	String s="catsanddog";
    	String[] strings={"cat","cats","and","sand","dog"};
    	Set<String> wordDict=new HashSet<>();
    	for(int i=0;i<strings.length;i++) wordDict.add(strings[i]);
    	System.out.println(new WordBreakII().wordBreak(s, wordDict));
    }

}

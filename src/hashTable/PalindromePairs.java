package hashTable;
import java.util.*;
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res=new ArrayList<>();
        if(words.length==0)return res;
        
        HashMap<String, Integer> map=new HashMap<>();//words中字符串-下标
        for(int i=0;i<words.length;i++) map.put(words[i], i);
        
        Integer empty=map.get("");
        if (empty!=null) {
			for(int i=0;i<words.length;i++){
				if(isPal(words[i])&&i!=empty){
					res.add(Arrays.asList(empty,i));
					res.add(Arrays.asList(i,empty));
				}
			}
		}
        
        for(int i=0;i<words.length;i++){//s1+s2,s1s2互相反转
        	Integer rev=map.get(reverse(words[i]));
        	if(rev!=null&&rev!=i) res.add(Arrays.asList(i,rev));
        }
        
        for(int i=0;i<words.length;i++){
        	for(int cut=1;cut<words[i].length();cut++){
        		if(isPal(words[i].substring(0, cut))){
        			//s1的[0.cut)回文,s2为s1[cut)的反转 s2+s1
        			Integer rev=map.get(reverse(words[i].substring(cut)));
        			if(rev!=null&&rev!=i) res.add(Arrays.asList(rev,i));
        		}
        		if(isPal(words[i].substring(cut))){
        			//s1的[cut)回文,s2为[0.cut)的反转 s1+s2
        			Integer rev=map.get(reverse(words[i].substring(0, cut)));
        			if(rev!=null&&rev!=i)res.add(Arrays.asList(i,rev));
        		}
        	}
        }
        return res;
    }
    
    private boolean isPal(String string){
    	int i=0,j=string.length()-1;
    	while(i<j){
    		if(string.charAt(i)!=string.charAt(j))return false;
    		i++;j--;
    	}
    	return true;
    }
    
    private String reverse(String string){
    	return new StringBuilder(string).reverse().toString();
    }
}

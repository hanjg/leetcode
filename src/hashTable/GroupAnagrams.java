package hashTable;
import java.util.*;
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> res=new ArrayList<>();
    	if(strs.length==0)return res;
    	HashMap<String, List<String>> map=new HashMap<>();//K=特征字符串，V=K对应的字符串列表
    	for(String string:strs){
    		char[] ca=string.toCharArray();
    		Arrays.sort(ca);
    		String feature=String.valueOf(ca);//ca.toString为ca的地址
    		if(!map.containsKey(feature))map.put(feature, new ArrayList<String>());
    		map.get(feature).add(string);
    	}
    	res.addAll(map.values());
    	return res;
    }

    public static void main(String[] args) {
		System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"",""}));
	}
}

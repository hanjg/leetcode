package hashTable;
import java.util.*;
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
    	if(s.length()!=t.length())return false;
    	Map<Character, Character> map=new HashMap<Character, Character>();
    	for(int i=0;i<t.length();i++){
    		if(map.containsKey(s.charAt(i))){
    			if(map.get(s.charAt(i))!=t.charAt(i))return false;
    		}
    		else{
    			if(map.containsValue(t.charAt(i)))return false;
    			else map.put(s.charAt(i), t.charAt(i));
    		}
    	}
    	return true;
    }

	public boolean isIsomorphic2(String s, String t) {
		if(s.length()!=t.length())return false;
		HashMap<Character, Integer> map1=new HashMap<>();
		HashMap<Character, Integer> map2=new HashMap<>();
		for(Integer i=0;i<s.length();i++){//Integer不能为int
			if(map1.put(s.charAt(i), i)!=map2.put(t.charAt(i), i))return false;
		}
		return true;
	}

	public boolean isIsomorphic3(String s, String t) {
		if(s.length()!=t.length())return false;
		int[]map1=new int[128],map2=new int[128];
		for(int i=0;i<s.length();i++){
			if(map1[s.charAt(i)]!=map2[t.charAt(i)])return false;
			map1[s.charAt(i)]=map2[t.charAt(i)]=i+1;
		}
		return true;
	}

	public static void main(String[] args){
		String pattern="ab";
		String str="aa";
		System.out.println(new IsomorphicStrings().isIsomorphic3(pattern, str));
	}


}

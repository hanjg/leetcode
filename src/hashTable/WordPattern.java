package hashTable;

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        char[] letters=pattern.toCharArray();
        String[] words=str.split(" ");
        int lp=letters.length,ls=words.length;
        if(lp!=ls)return false;
        HashMap<Character, String> map=new HashMap<>();
        for(int i=0;i<lp;i++){
        	if(map.containsKey(letters[i])){
        		if(!map.get(letters[i]).equals(words[i])) return false;
        	}
        	else {
				if(map.containsValue(words[i])) return false;
				else map.put(letters[i], words[i]);
			}
        }
        return true;
    }
    public static void main(String[] args){
    	String pattern="abba";
    	String str="dog cat cat dog";
    	System.out.println(new WordPattern().wordPattern(pattern, str));
    }
}

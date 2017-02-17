package hashTable;
import java.util.*;
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result=new HashSet<>();
        if(s.length()<10)return new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        for(int i=0;i+9<s.length();i++){
        	String string=s.substring(i, i+10);
        	if(!set.add(string)) result.add(string);
        }
        return new ArrayList<>(result);
    }

	public List<String> findRepeatedDnaSequences2(String s) {
	    if(s.length()<10)return new ArrayList<>();
	    HashSet<Integer> set=new HashSet<>();
	    HashSet<Integer> mulSet=new HashSet<>();
	    List<String> result=new ArrayList<>();
	    
	    int[] map=new int[26];//建立字母和数字的映射,之后10个字母可用20个bit位表示
	    map['T'-'A']=1;
	    map['C'-'A']=2;
	    map['G'-'A']=3;
	    
	    for(int i=0;i+9<s.length();i++){
	    	int b=0;
	    	for(int j=i;j<i+10;j++){
	    		b=b<<2;
	    		b|=map[s.charAt(j)-'A'];
	    	}
	    	if(!set.add(b)&&mulSet.add(b)) result.add(s.substring(i,i+10));
	    }
	    return result;
	}

}

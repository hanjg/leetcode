package math;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
    public int romanToInt(String s) {
    	if(s.length()==0)return 0;
    	Map<Character, Integer> map=new HashMap<>();
    	map.put('I', 1);map.put('V', 5);
    	map.put('X', 10);map.put('L', 50);
    	map.put('C', 100);map.put('D', 500);
    	map.put('M', 1000);
        int res=map.get(s.charAt(s.length()-1));
        for(int i=s.length()-2;i>=0;i--){
        	if(map.get(s.charAt(i))<map.get(s.charAt(i+1)))res-=map.get(s.charAt(i));
        	else res+=map.get(s.charAt(i));
        }
        return res;
    }

	public int romanToInt2(String s) {
		if(s.length()==0)return 0;
		String string="IVXLCDM";
		int[] num={1,5,10,50,100,500,1000};
		int idlater=string.indexOf(s.charAt(s.length()-1));//idlater,idcur表示字符在num中的下标
		int res=num[idlater];
		for(int i=s.length()-2;i>=0;i--){
			int idcur=string.indexOf(s.charAt(i));
			if(num[idlater]>num[idcur])res-=num[idcur];
			else res+=num[idcur];
			idlater=idcur;
		}
	    return res;
	}

}

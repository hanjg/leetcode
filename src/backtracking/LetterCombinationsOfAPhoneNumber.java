package backtracking;
import java.util.*;
public class LetterCombinationsOfAPhoneNumber {
	String[] keys={" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	//每个数字可能代表的字符
	List<String>result;
    public List<String> letterCombinations(String digits) {
        result=new ArrayList<>();
        if(digits.length()==0)return result;
        getNum(digits, 0, "");
        return result;
    }	
    
    private void getNum(String digits,int i,String pre){//取digits下标为i的数字对应的字符
    	if (i==digits.length()) {
			result.add(pre);return;
		}
    	String cand=keys[digits.charAt(i)-'0'];
    	for(int j=0;j<cand.length();j++){
    		getNum(digits, i+1, pre+cand.charAt(j));
    	}
    }

}

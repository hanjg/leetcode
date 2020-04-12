package backtracking;
import java.util.*;
public class ExpressionAddOperators {
	List<String> result;
	String num;
    public List<String> addOperators(String num, int target) {
        result=new ArrayList<>();
        this.num=num;
        //dfs("", 0, 1, target);
        dfs2("", 0, 0, target);
        return result;
    }
    
    @SuppressWarnings("unused")
	private void dfs(String path,int start,long cache,long target){//慢
    	//start:num的下标。sign当前数据的符号。cur暂时存储还未加入和的数据
    	//1*2*3*4*5-6-78+9,1*2*3*4+5+6-7+8+9
    	if (start==num.length()) {
			if (cache==target) {
				result.add(path);
			}
			return;
		}
    	for(int i=start;i<num.length();i++){//数据取到下标为i，数据为[start,i]
    		if(i>start&&num.charAt(start)=='0')break;//排除"05"这一类数
    		long temp=Long.parseLong(num.substring(start, i+1));
    		if (i==num.length()-1) {
    			dfs(path+temp, i+1, cache*temp, target);
			}else {
	    		dfs(path+temp+"*", i+1, cache*temp, target);
	    		dfs(path+temp+"+", i+1, 1,target-cache*temp);
	    		dfs(path+temp+"-", i+1, -1,  target-cache*temp);
			}
    	}
    }
    
    private void dfs2(String path,int start,long cache,long target){
		if (start==num.length()) {
			if (cache==target) {
				result.add(path);
			}
			return;
		}
		for(int i=start;i<num.length();i++){//数据取到下标为i，数据为[start,i]
			if(i>start&&num.charAt(start)=='0')break;//排除"05"这一类数
			long temp=Long.parseLong(num.substring(start, i+1));
			if (start==0) {
				dfs2(path+temp, i+1, temp, target);
			}else {
	    		dfs2(path+"*"+temp, i+1, cache*temp, target);
	    		dfs2(path+"+"+temp, i+1, temp,target-cache);
	    		dfs2(path+"-"+temp, i+1, -temp,  target-cache);
			}
		}
	}

	public static void main(String[] args){
    	System.out.println(new ExpressionAddOperators().addOperators("105", 5));
    	/*String[] strings={"1+2+3+4+5+6+7+8+9","1+2+3+4+5-6*7+8*9","1+2+3+4-5*6+7*8+9","1+2+3+4-5*6-7+8*9","1+2+3-4*5+6*7+8+9","1+2+3-4*5-6+7*8+9","1+2+3-4*5-6-7+8*9","1+2+3*4+5+6*7-8-9","1+2+3*4*5+6-7-8-9","1+2+3*45+6-7*8*9","1+2-3+4*5+6*7-8-9","1+2-3-4-5*6+7+8*9","1+2-3*4+5*6+7+8+9","1+2-3*4-5+6*7+8+9","1+2-3*4-5-6+7*8+9","1+2-3*4-5-6-7+8*9","1+2*3+4*5-6+7+8+9","1+2*3*4+5*6+7-8-9","1+2*3*4-5+6*7-8-9","1+23+4-5*6+7+8+9","1+23-4*5-6+7+8+9","1-2+3*4*5-6-7+8-9","1-2-3*4+5+6+7*8-9","1-2*3+4+5+6*7+8-9","1-2*3+4+5-6+7*8-9","1-2*3+4*5+6+7+8+9","1-2*3+4*5-6*7+8*9","1-2*3-4+5*6+7+8+9","1-2*3-4-5+6*7+8+9","1-2*3-4-5-6+7*8+9","1-2*3-4-5-6-7+8*9","1-2*3*4-5-6+7+8*9","1*2+3+4+5*6+7+8-9","1*2+3+4-5+6*7+8-9","1*2+3+4-5-6+7*8-9","1*2*3+4+5+6+7+8+9","1*2*3+4+5-6*7+8*9","1*2*3+4-5*6+7*8+9","1*2*3+4-5*6-7+8*9","1*2*3-4*5+6*7+8+9","1*2*3-4*5-6+7*8+9","1*2*3-4*5-6-7+8*9","1*2*3*4+5+6-7+8+9","1*23+4-5+6-7-8+9","1*23+4-5-6+7+8-9","1*23-4+5+6-7+8-9","12+3*4+5+6-7+8+9","12-3+4*5+6-7+8+9","12-3-4+5*6-7+8+9","12-34*5+6+78-9","12*3+4+5+6-7-8+9","12*3+4+5-6+7+8-9","12*3-4-5-6+7+8+9"};
    	String[] strings2={"1*2*3*4*5-6-78+9","1*2*3*4+5+6-7+8+9","1*2*3+4+5+6+7+8+9","1*2*3+4+5-6*7+8*9","1*2*3+4-5*6+7*8+9","1*2*3+4-5*6-7+8*9","1*2*3-4*5+6*7+8+9","1*2*3-4*5-6+7*8+9","1*2*3-4*5-6-7+8*9","1*2*3-45+67+8+9","1*2*34+56-7-8*9","1*2*34-5+6-7-8-9","1*2+3*4-56+78+9","1*2+3+4+5*6+7+8-9","1*2+3+4-5+6*7+8-9","1*2+3+4-5-6+7*8-9","1*2+3+45+67-8*9","1*2+3-45+6+7+8*9","1*2+34+5-6-7+8+9","1*2+34+56-7*8+9","1*2+34-5+6+7-8+9","1*2+34-56+7*8+9","1*2+34-56-7+8*9","1*2-3*4+5+67-8-9","1*2-3+4-5-6*7+89","1*2-3-4*5+67+8-9","1*2-3-4+56-7-8+9","1*2-34+5*6+7*8-9","1*23+4*5-6+7-8+9","1*23-4-56-7+89","1+2*3*4*5+6+7-89","1+2*3*4+5*6+7-8-9","1+2*3*4-5+6*7-8-9","1+2*3+4*5*6+7-89","1+2*3+4*5-6+7+8+9","1+2*3-4-5-6*7+89","1+2*34-5*6+7+8-9","1+2+3*4*5+6-7-8-9","1+2+3*4+5+6*7-8-9","1+2+3*45-6-78-9","1+2+3+4+5+6+7+8+9","1+2+3+4+5-6*7+8*9","1+2+3+4-5*6+7*8+9","1+2+3+4-5*6-7+8*9","1+2+3-4*5+6*7+8+9","1+2+3-4*5-6+7*8+9","1+2+3-4*5-6-7+8*9","1+2+3-45+67+8+9","1+2-3*4*5+6+7+89","1+2-3*4+5*6+7+8+9","1+2-3*4-5+6*7+8+9","1+2-3*4-5-6+7*8+9","1+2-3*4-5-6-7+8*9","1+2-3+4*5+6*7-8-9","1+2-3+45+6-7-8+9","1+2-3+45-6+7+8-9","1+2-3-4-5*6+7+8*9","1+2-3-45-6+7+89","1+2-34+5+6+7*8+9","1+2-34+5+6-7+8*9","1+2-34-5-6+78+9","1+23*4+5-6-7*8+9","1+23*4-5-6*7+8-9","1+23*4-56+7-8+9","1+23+4+5+6+7+8-9","1+23+4-5*6+7*8-9","1+23+4-5-67+89","1+23-4*5+6*7+8-9","1+23-4*5-6+7*8-9","1+23-4-5+6+7+8+9","1+23-4-5-6*7+8*9","1+23-45+67+8-9","1-2*3*4+5-6+78-9","1-2*3*4-5-6+7+8*9","1-2*3+4*5+6+7+8+9","1-2*3+4*5-6*7+8*9","1-2*3+4+5+6*7+8-9","1-2*3+4+5-6+7*8-9","1-2*3+4+56+7-8-9","1-2*3+45-67+8*9","1-2*3-4+5*6+7+8+9","1-2*3-4-5+6*7+8+9","1-2*3-4-5-6+7*8+9","1-2*3-4-5-6-7+8*9","1-2*34+5*6-7+89","1-2+3*4*5-6-7+8-9","1-2+3+4-5*6+78-9","1-2+3+45+6-7+8-9","1-2+3-4*5-6+78-9","1-2+3-45+6-7+89","1-2-3*4+5+6+7*8-9","1-2-3*4-5-6+78-9","1-2-3+4-5+67-8-9","1-2-3+45-6-7+8+9","1-2-34+5+6+78-9","1-2-34+56+7+8+9","1-2-34-5+6+7+8*9","1-23*4+5+6*7+89","1-23+4*5-6*7+89","1-23+4-5+67-8+9","1-23+45-67+89","1-23-4+5+67+8-9","1-23-4-5-6-7+89","12*3*4-5*6-78+9","12*3+4+5+6-7-8+9","12*3+4+5-6+7+8-9","12*3-4-5-6+7+8+9","12*3-4-56+78-9","12+3*4+5+6-7+8+9","12+3*45-6-7-89","12+3+4-56-7+89","12+3-4*5+67-8-9","12+3-45+6+78-9","12+34-5-6-7+8+9","12-3*4*5+6+78+9","12-3*4-5+67-8-9","12-3+4*5+6-7+8+9","12-3+4+56-7-8-9","12-3-4+5*6-7+8+9","12-3-4-56+7+89","12-3-45-6+78+9"};
    	Arrays.sort(strings);Arrays.sort(strings2);
    	for(int i=0;i<strings.length;i++){
    		System.out.println(strings[i]+"\t"+strings2[i]);
    	}*/
    }
}
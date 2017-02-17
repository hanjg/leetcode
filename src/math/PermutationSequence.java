package math;

import java.util.*;

public class PermutationSequence {
	public String getPermutation(int n, int k){//首字母不同的字符串有n组各(n-1)！个
		StringBuilder builder=new StringBuilder();
		StringBuilder src=new StringBuilder();
		for(int i=1;i<=n;i++) src.append(i);
		int fact=1;
		for(int i=2;i<=n;i++) fact*=i;//初始值为n!
		k--;//由第k个变为下标k
		for(int i=0;i<n;i++){//寻找结果中下标为i的字符,范围为src，是src的全排列中的下标k的首字母
			fact/=(n-i);//首字母不同的字符串每一组的个数
			int t=k/fact;
			builder.append(src.charAt(t));src.deleteCharAt(t);
			k%=fact;
		}
		return builder.toString();
	}

	String result;
	List<Integer> src;
	int count;
    public String getPermutation2(int n, int k) {//backtracking超时
        count=0;
        src=new ArrayList<>();
        for(int i=1;i<=n;i++){
        	src.add(i);
        }
        dfs(n, k,"");
        return result;
    }
    private void dfs(int n,int k,String string){
    	if (src.size()==0) {
			count++;
			if (count==k) {
				result=string;
			}
		}
    	for(int i=0;i<src.size();i++){
    		int temp=src.get(i);
    		src.remove(i);
    		dfs(n, k, string+temp);
    		src.add(i, temp);
    	}
    }
	public static void main(String[] args) {
		PermutationSequence test=new PermutationSequence();
		System.out.println(test.getPermutation(9, 54494));
	}

}

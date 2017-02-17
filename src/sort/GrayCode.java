package sort;
import java.util.*;
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res=new ArrayList<>();
        int top=1<<n;
        for(int i=0;i<top;i++) res.add(i^(i>>1));//一种通项公式i^(i>>1)
        return res;
    }

	public List<Integer> grayCode2(int n) {
	    List<Integer> res=new ArrayList<>();
	    res.add(0);
	    for(int i=0;i<n;i++){
	    	int increase=1<<i;
	    	//从后往前给res中的每个数加上increase
	    	for(int j=res.size()-1;j>=0;j--) res.add(res.get(j)+increase);
	    }
	    return res;
	}
	public static void main(String[] args) {
		GrayCode grayCode=new GrayCode();
		System.out.println(grayCode.grayCode(3));
		System.out.println(grayCode.grayCode2(3));
	}
}

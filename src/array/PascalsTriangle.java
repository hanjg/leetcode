package array;
import java.util.*;
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        if(numRows<=0)return res;
        res.add(Arrays.asList(1));
        if(numRows==1)return res;
        res.add(Arrays.asList(1,1));
        if(numRows==2)return res;
        for(int i=2;i<numRows;i++){
        	List<Integer> coList=new ArrayList<>();
        	coList.add(1);
        	List<Integer> pre=res.get(i-1);
        	for(int j=1;j<i;j++){
        		coList.add(pre.get(j-1)+pre.get(j));
        	}
        	coList.add(1);
        	res.add(coList);
        }
        return res;
    }

}

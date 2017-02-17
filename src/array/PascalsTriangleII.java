package array;
import java.util.*;
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list=new ArrayList<>();
        if(rowIndex<0)return list;
        for(int i=0;i<=rowIndex;i++){
        	list.add(0,1);
        	for(int j=1;j<list.size()-1;j++){//除了0,size-1不设置，设置[1,size-2]的数
        		list.set(j, list.get(j)+list.get(j+1));
        	}
        }
        return list;
    }

}

package hashTable;

import java.util.*;

public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        List<Integer> res=new ArrayList<>();
        for(int num:nums1) set.add(num);
        for(int num:nums2){
        	if(set.contains(num)){
        		res.add(num);set.remove(num);
        	}
        }
        int[] result=new int[res.size()];
        int i=0;
        for(int num:res)result[i++]=num;
        return result;
    }
}

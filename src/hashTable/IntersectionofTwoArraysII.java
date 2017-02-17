package hashTable;

import java.util.*;

public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map=new HashMap<>();
        List<Integer> res=new ArrayList<>();
        for(int num:nums1){
        	if(!map.containsKey(num))map.put(num, 1);
        	else map.put(num, map.get(num)+1);
        }
        for(int num:nums2){
        	if(map.containsKey(num)){
        		res.add(num);
        		if(map.get(num)==1)map.remove(num);
        		else map.put(num, map.get(num)-1);
        	}
        }
        int[] result=new int[res.size()];
        int i=0;
        for(int num:res)result[i++]=num;
        return result;
    }
    
    public int[] intersect2(int[] nums1, int[] nums2) {
    	Arrays.sort(nums1);Arrays.sort(nums2);
    	List<Integer> res=new ArrayList<>();
    	int i=0,j=0;
    	while(i<nums1.length&&j<nums2.length){
    		if(nums1[i]==nums2[j]){res.add(nums1[i]);i++;j++;}
    		else if(nums1[i]<nums2[j])i++;
    		else j++;
    	}
    	int[] result=new int[res.size()];
    	i=0;
    	for(int num:res) result[i++]=num;
    	return result;
	}

	public static void main(String[] args) {
		new IntersectionofTwoArraysII().intersect(new int[]{}, new int[]{});
	}
}

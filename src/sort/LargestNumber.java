package sort;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
    	String[] copy=new String[nums.length];
    	for(int i=0;i<nums.length;i++)copy[i]=String.valueOf(nums[i]);
        Arrays.sort(copy, 0, nums.length, new Comparator<String>() {
        	public int compare(String s1,String s2){
        		return (s2+s1).compareTo(s1+s2);
        	}
		});
        if(Integer.valueOf(copy[0])==0)return "0";
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<copy.length;i++){
        	builder.append(copy[i]);
        }
        return builder.toString();
    }
}

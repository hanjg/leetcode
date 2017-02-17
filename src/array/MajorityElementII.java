package array;
import java.util.*;
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<>();
        if(nums.length==0)return res;
        int n1=nums[0],n2=nums[0],c1=0,c2=0;//c1,c2为n1,n2的计数,n1,n2出现最多的两个数
        for(int num:nums){
        	if(num==n1)c1++;
        	else if(num==n2)c2++;
        	else if(c1==0){n1=num;c1=1;}
        	else if(c2==0){n2=num;c2=1;}
        	else {c1--;c2--;}
        }
        int count1=0,count2=0;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]==n1)count1++;
        	else if(nums[i]==n2)count2++;
        }
        if(count1>nums.length/3)res.add(n1);
        if(count2>nums.length/3)res.add(n2);
        return res;
    }


}

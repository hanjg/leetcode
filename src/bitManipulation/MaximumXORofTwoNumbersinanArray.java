package bitManipulation;

import java.util.HashSet;

public class MaximumXORofTwoNumbersinanArray {
    public int findMaximumXOR(int[] nums) {
        int n=nums.length;
        if(n<=1)return 0;
        int res=0,mask=0;
        for(int i=31;i>=0;i--){//依次求得每一个前缀的最大值
        	mask|=1<<i;
        	HashSet<Integer> set=new HashSet<>();//储存nums中元素的前缀
        	for(int num:nums) set.add(num&mask);
        	int temp=res|(1<<i);//当前res下可取的最大前缀,即该位置取1
        	for(int pre:set)//判断是否可以取temp
        		if(set.contains(temp^pre)) res=temp;//temp^pre=x->temp=x^pre
        }
        return res;
    }
}

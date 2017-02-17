package hashTable;

import java.util.HashMap;

public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        long num=numerator,den=denominator;
        if(num==0||den==0)return "0";
        String sign=(num>0&&den>0)||(num<0&&den<0)?"":"-";
        num=Math.abs(num);den=Math.abs(den);
        String interger=sign+num/den;
        num=num%den;//余数
        if(num!=0){//有小数部分
        	StringBuilder builder=new StringBuilder();
        	HashMap<Long, Integer>map=new HashMap<>();
        	//K=余数V=由余数*10/den得到的数字在builder中的位置
        	int pos=0;
        	while(num!=0){
        		map.put(num, pos++);
        		num*=10;builder.append(num/den);
        		num%=den;
        		if(map.containsKey(num)){
        			int begin=map.get(num);//循环开始的位置
        			return interger+"."+builder.substring(0, begin)+
        					"("+builder.substring(begin)+")";
        		}
        	}
        	return interger+"."+builder.toString();
        }
        return interger;
    }
}

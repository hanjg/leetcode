package string;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
    	if(numRows<2)return s;
    	StringBuilder[] builders=new StringBuilder[numRows];
    	int T=2*numRows-2;//周期
    	for(int i=0;i<numRows;i++){//按行数添加字符
    		builders[i]=new StringBuilder();
    		for(int j=i;j<s.length();j+=T){
    			builders[i].append(s.charAt(j));
    			if(i!=0&&i!=numRows-1&&j+T-2*i<s.length())
    				builders[i].append(s.charAt(j+T-2*i));
    		}
    	}
    	for(int i=1;i<numRows;i++){
    		builders[0].append(builders[i]);
    	}
    	return builders[0].toString();
    }
}

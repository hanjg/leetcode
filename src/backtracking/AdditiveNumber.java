package backtracking;

public class AdditiveNumber {
	int n;
    public boolean isAdditiveNumber(String num) {
        n=num.length();if(n<3)return false;
        long first,second;
        for(int i=1;i<=n/3;i++){//[0,i)
        	if((i>1&&num.charAt(0)=='0'))break;
        	first=Long.valueOf(num.substring(0, i));
        	int max2=i+(n-i)/2;//j的最大值
        	for(int j=i+1;j<=max2;j++){//[i,j)
        		if((j-i>1&&num.charAt(i)=='0'))break;
        		second=Long.valueOf(num.substring(i, j));
        		if(isAdd(num, first, second, j))return true;
        	}
        }
        return false;
    }
    private boolean isAdd(String num,long first,long second,int begin){
    	if(begin==n)return true;
    	long ex=first+second;
    	for(int end=begin+1;end<=n;end++){
    		if((end-begin>1&&num.charAt(begin)=='0'))break;
    		long third=Long.valueOf(num.substring(begin,end));
    		if(third>ex)break;
    		if(third==ex)return isAdd(num, second, third, end);
    	}
    	return false;
    }
    public static void main(String[] args) {
		System.out.println(new AdditiveNumber().isAdditiveNumber("121474836472147483648"));
	}
}

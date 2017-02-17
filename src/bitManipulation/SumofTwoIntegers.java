package bitManipulation;

public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        while(b!=0){
        	int sum=a^b;//不考虑进位计算a+b
        	b=(a&b)<<1;//计算a+b的进位
        	a=sum;
        }
        return a;
    }

}

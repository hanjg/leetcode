package bitManipulation;

public class IntegerReplacement {
    public int integerReplacement(int n) {
    	long num=n;
        int count=0;
        while(num!=1){
        	if((num&1)==0)num>>=1;
        	else if(num==3)num--;
        	//奇数+-1之后为一个4的倍数和一个2的倍数
        	else if(((num-1)&0b10)==0)num--;//4的倍数
        	else num++;//2的倍数
        	count++;
        }
        return count;
    }
    public static void main(String[] args) {
		System.out.println(new IntegerReplacement().integerReplacement(2147483647));
	}
}

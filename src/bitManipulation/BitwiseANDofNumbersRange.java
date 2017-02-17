package bitManipulation;

public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int num=0;//记录末尾0的数量:m!=n则末尾一定为0
        while(m!=n){
        	num++;
        	m>>=1;n>>=1;
        }
        return n<<num;
    }
}

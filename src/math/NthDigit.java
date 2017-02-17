package math;

public class NthDigit {
    public int findNthDigit(int n) {
        int digit=1,first=1;//digit位的数，个数为amount,第一个数为first
        long amount=9;
        while(n>digit*amount){
        	n-=digit*amount;
        	digit++;amount*=10;first*=10;
        }
        int before=first-1+(n-1)/digit;//n之前最大的完整的数
        int now=before+1;//n所处的数
        String string=Integer.toString(now);
        return Character.getNumericValue(string.charAt((n-1)%digit));
    }
    public static void main(String[]args){
    	System.out.println(new NthDigit().findNthDigit(2147483647));
    }
}

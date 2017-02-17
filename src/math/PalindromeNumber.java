package math;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        else if(x<10)return true;
        else if(x%10==0)return false;
        int rev=0;
        while(x>rev){
        	rev=10*rev+x%10;
        	x/=10;
        }     
        return x==rev||x==rev/10;//x为偶数位和奇数位
    }

}

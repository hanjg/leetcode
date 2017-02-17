package hashTable;

import java.util.HashSet;

public class HappyNumber {

    public boolean isHappy(int n) {
        if (n<=0) {
			return false;
		}
        HashSet<Integer> set=new HashSet<>();
        while(n!=1){
        	set.add(n);
        	int sum=0;
        	while(n>0){
        		sum+=(int)Math.pow((n%10), 2);
        		n/=10;
        	}
        	n=sum;//System.out.println(n);
        	if (set.contains(n)) {
				return false;
			}
        }
        return true;
    }
    
    public static void main(String[] args){
    	HappyNumber number=new HappyNumber();
    	System.out.println(number.isHappy(3));
    }
}

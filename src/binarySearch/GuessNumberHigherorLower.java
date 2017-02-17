package binarySearch;

public class GuessNumberHigherorLower {
	int guess(int num){
		return 0;
	}
    public int guessNumber(int n) {
    	int l=1,r=n;
    	while(l<=r){
    		int mid=(r-l)/2+l;
    		int res=guess(mid);
    		if(res==0)return mid;
    		else if(res==1)l=mid+1;
    		else r=mid-1;
    	}
    	return n;
    }
    public static void main(String[]args){
    	System.out.println(new GuessNumberHigherorLower().guessNumber(10));
    }

}

package dp;

public class CountingBits {
    public int[] countBits(int num) {
        int[] r=new int[num+1];
        r[0]=0;
        for(int i=1;i<=num;i++){
        	r[i]=((i&1)==1)?r[i>>1]+1:r[i>>1];//讨论i为奇数和偶数的情况
        }
        return r;
    }

    public static void main(String[] args){
    	int[] r=new CountingBits().countBits(2);
    	for(int i=0;i<r.length;i++) System.out.print(r[i]+" ");
    }
}

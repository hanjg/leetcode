package math;

public class EliminationGame {
    public int lastRemaining(int n) {
    	int head=1,remain=n,gap=1;
    	boolean fromleft=true;
    	while(remain>1){
    		if(fromleft||remain%2==1)head+=gap;//当从左边取出和从右边去除且remain奇数，head变化
    		gap*=2;remain/=2;
    		fromleft=!fromleft;
    	}
    	return head;
    }
    public static void main(String[] args) {
    	int res=new EliminationGame().lastRemaining(6);
		System.out.println(res);
	}
}

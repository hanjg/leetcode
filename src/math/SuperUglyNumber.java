package math;

import java.util.PriorityQueue;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] sUNum=new int[n];
        sUNum[0]=1;
        int[] pointers=new int[primes.length];//pointers[i]:可以用乘primes[i]来生成新的sUnum的sUNum下标
        for(int i=1;i<n;i++){
        	sUNum[i]=Integer.MAX_VALUE;
        	for(int j=0;j<primes.length;j++){
        		sUNum[i]=Math.min(sUNum[i], sUNum[pointers[j]]*primes[j]);
        	}
        	for(int j=0;j<primes.length;j++){
        		if (sUNum[pointers[j]]*primes[j]==sUNum[i]) {
					pointers[j]++;
				}
        	}
        }
        return sUNum[n-1];
    }

	public int nthSuperUglyNumber2(int n, int[] primes) {
	    int[] sUNum=new int[n];
	    sUNum[0]=1;
	    int[] pointers=new int[primes.length];//pointers[i]:可以用乘primes[i]来生成新的sUnum的sUNum下标
	    PriorityQueue<Integer> queue=new PriorityQueue<>();
	    for(int i=1;i<n;i++){
		    for(int j=0;j<primes.length;j++){
		    	queue.add(sUNum[pointers[j]]*primes[j]);
		    }
	    	sUNum[i]=queue.peek();
	    	for(int j=0;j<primes.length;j++){
	    		if (sUNum[i]==sUNum[pointers[j]]*primes[j]) {
					pointers[j]++;
				}
	    	}
	    	queue.clear();
	    }
	    return sUNum[n-1];
	}
	public int nthSuperUglyNumber3(int n, int[] primes) {
	    int[] sUNum=new int[n];
	    sUNum[0]=1;
	    int[] pointers=new int[primes.length];//pointers[i]:可以用乘primes[i]来生成新的sUnum的sUNum下标
	    PriorityQueue<Integer> queue=new PriorityQueue<>();
		for(int j=0;j<primes.length;j++){
		 	queue.add(sUNum[pointers[j]]*primes[j]);
		}
	    for(int i=1;i<n;i++){
	    	sUNum[i]=queue.peek();
	    	for(int j=0;j<primes.length;j++){
	    		if (sUNum[i]==sUNum[pointers[j]]*primes[j]) {
					pointers[j]++;
				}
	    	}
	    	queue.clear();
	    }
	    return sUNum[n-1];
	}

	public static void main(String[] args){
		SuperUglyNumber sNumber=new SuperUglyNumber();
		int[] primes={2,7,13,19};
		System.out.println(sNumber.nthSuperUglyNumber(12, primes));
	}
}

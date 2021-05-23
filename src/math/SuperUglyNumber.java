package math;

/**
 * problems-313 https://leetcode-cn.com/problems/super-ugly-number/
 */
public class SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        //pointers[i]:uglyNums[pointers[i]]乘primes[i]为下一个解
        int[] pointers = new int[primes.length];
        for (int i = 1; i < n; i++) {
            //求下一个解
            int nextNum = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                nextNum = Math.min(nextNum, uglyNums[pointers[j]] * primes[j]);
            }
            //找下一个可行的入节点
            for (int j = 0; j < primes.length; j++) {
                if (uglyNums[pointers[j]] * primes[j] == nextNum) {
                    pointers[j]++;
                }
            }
            uglyNums[i] = nextNum;
        }

        return uglyNums[n - 1];
    }

//	public int nthSuperUglyNumber2(int n, int[] primes) {
//	    int[] sUNum=new int[n];
//	    sUNum[0]=1;
//	    int[] pointers=new int[primes.length];//pointers[i]:可以用乘primes[i]来生成新的sUnum的sUNum下标
//	    PriorityQueue<Integer> queue=new PriorityQueue<>();
//	    for(int i=1;i<n;i++){
//		    for(int j=0;j<primes.length;j++){
//		    	queue.add(sUNum[pointers[j]]*primes[j]);
//		    }
//	    	sUNum[i]=queue.peek();
//	    	for(int j=0;j<primes.length;j++){
//	    		if (sUNum[i]==sUNum[pointers[j]]*primes[j]) {
//					pointers[j]++;
//				}
//	    	}
//	    	queue.clear();
//	    }
//	    return sUNum[n-1];
//	}
//	public int nthSuperUglyNumber3(int n, int[] primes) {
//	    int[] sUNum=new int[n];
//	    sUNum[0]=1;
//	    int[] pointers=new int[primes.length];//pointers[i]:可以用乘primes[i]来生成新的sUnum的sUNum下标
//	    PriorityQueue<Integer> queue=new PriorityQueue<>();
//		for(int j=0;j<primes.length;j++){
//		 	queue.add(sUNum[pointers[j]]*primes[j]);
//		}
//	    for(int i=1;i<n;i++){
//	    	sUNum[i]=queue.peek();
//	    	for(int j=0;j<primes.length;j++){
//	    		if (sUNum[i]==sUNum[pointers[j]]*primes[j]) {
//					pointers[j]++;
//				}
//	    	}
//	    	queue.clear();
//	    }
//	    return sUNum[n-1];
//	}

    public static void main(String[] args) {
        SuperUglyNumber sNumber = new SuperUglyNumber();
        int[] primes = {3, 5, 7, 11, 19, 23, 29, 41, 43, 47};
        System.out.println(sNumber.nthSuperUglyNumber(15, primes));
    }
}

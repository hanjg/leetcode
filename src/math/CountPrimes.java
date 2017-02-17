package math;

public class CountPrimes {

    public int countPrimes(int n) {
        boolean[] isPrime=new boolean[n];//isPrime[i]表示数字i是否为素数
        for(int i=0;i<n;i++) isPrime[i]=true;
        for(int i=2;i*i<n;i+=2){//标出i的倍数
        	if (!isPrime[i]) {
				continue;
			}
        	for(int j=i;j*i<n;j++){
        		isPrime[i*j]=false;
        	}
        }
        int count=0;
        for(int i=2;i<n;i++){
        	if (isPrime[i]) {
				count++;
			}
        }
        return count;
    }
}

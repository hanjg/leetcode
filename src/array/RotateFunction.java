package array;

public class RotateFunction {
    public int maxRotateFunction(int[] A) {
    	int n=A.length;if(n==0)return 0;
        int sum=0,F=0;
        for(int i=0;i<n;i++){sum+=A[i];F+=i*A[i];}
        int max=F;
        for(int i=1;i<n;i++)max=Math.max(max, F+=sum-n*A[n-i]);
        return max;
    }
}

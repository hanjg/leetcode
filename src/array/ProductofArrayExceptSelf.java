package array;

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        if(n==0||n==1)return null;
        int[] pre=new int[n],post=new int[n];//i之前和之后所有树的乘积
        pre[0]=post[n-1]=1;
        for(int i=1;i<n;i++){
        	pre[i]=pre[i-1]*nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
        	post[i]=post[i+1]*nums[i+1];
        }
        int[] res=new int[n];
        for(int i=0;i<n;i++){
        	res[i]=pre[i]*post[i];
        }
        return res;
    }

	public int[] productExceptSelf2(int[] nums) {
	    int n=nums.length;
	    if(n==0||n==1)return null;
	    int[]res=new int[n];
	    res[0]=1;//先求i之前所有的数，在乘i之后所有的数
	    for(int i=1;i<n;i++){
	    	res[i]=res[i-1]*nums[i-1];
	    }
	    int right=1;
	    for(int i=n-2;i>=0;i--){
	    	right*=nums[i+1];
	    	res[i]*=right;
	    }
	    return res;
	}

}

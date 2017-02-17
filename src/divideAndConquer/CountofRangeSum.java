package divideAndConquer;

public class CountofRangeSum {
	long[] sums;
    public int countRangeSum(int[] nums, int lower, int upper) {
        sums=new long[nums.length+1];//sums[i]表示前i个数的和sums[i]-sums[i-1]表示第i个数nums[i-1]
        for(int i=1;i<=nums.length;i++){
        	sums[i]=sums[i-1]+nums[i-1];
        }
        return countRS(0, sums.length-1, lower, upper);
    }
    
    private int countRS(int begin,int end,int lower,int upper){//sums[begin,end]
    	if (end<=begin) {
			return 0;
		}
    	int mid=(begin+end)/2;
    	int count=countRS(begin, mid, lower, upper)+countRS(mid+1, end, lower, upper);
    	
    	int j=mid+1,k=mid+1;//j第一个满足sums[j]-sums[i]>upper,k第一个满足sums[k]-sums[i]>=lower
    	int t=mid+1;//用来复制sums[t]<sums[i]的元素到temp
    	long[] temp=new long[end-begin+1];
    	//按顺序存储归并好的sums[begin,end],不一定填满，长度为t-begin，因为可能存在>sum[mid]的数
    	//j,k,t均在待归并的第二组
    	
    	for(int i=begin,r=0;i<=mid;i++,r++){//r表示temp中的指针
    		while(k<=end&&sums[k]-sums[i]<lower) k++;
    		while(j<=end&&sums[j]-sums[i]<=upper) j++;
    		while(t<=end&&sums[t]<sums[i]) temp[r++]=sums[t++];
    		temp[r]=sums[i];
    		count+=j-k;
    	}
    	System.arraycopy(temp, 0, sums, begin, t-begin);
    	return count;
    }
	public static void main(String[] args) {
		CountofRangeSum test=new CountofRangeSum();
		int[] nums={2147483647,-2147483648,-1,0};
		System.out.println(test.countRangeSum(nums, -1, 0));
	}

}

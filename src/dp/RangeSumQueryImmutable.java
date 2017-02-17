package dp;

public class RangeSumQueryImmutable {
	int[] sum;//[0,i)
	
    public RangeSumQueryImmutable(int[] nums) {
    	sum=new int[nums.length+1];
    	for(int i=1;i<=nums.length;i++) sum[i]=sum[i-1]+nums[i-1];
    }

    public int sumRange(int i, int j) {
        return sum[j+1]-sum[i];  
    }
    public static void main(String[] args) {
		new RangeSumQueryImmutable(new int[]{-2,0,3,-5,2,-1});
	}
}

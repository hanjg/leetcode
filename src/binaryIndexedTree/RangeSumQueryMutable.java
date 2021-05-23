package binaryIndexedTree;

/**
 * 树状数组
 */
public class RangeSumQueryMutable {
	int[] nums;//[0,n)
	int n;
	int[] bit;//[1,n]

    public RangeSumQueryMutable(int[] nums) {
        this.nums=nums;
        n=nums.length;
        bit=new int[n+1];
        for(int i=0;i<n;i++) updatabit(i, nums[i]);
    }

    void update(int i, int val) {//nums的下标和新的值
        updatabit(i, val-nums[i]);
        nums[i]=val;
    }

    public int sumRange(int i, int j) {
        return sum(j)-sum(i-1);
    }

	private void updatabit(int i,int dif){//nums的下标和新的值
		i++;//bit中的下标
		while(i<=n){
			bit[i]+=dif;
			i+=(i&-i);//(i&-i)bit[i]表示的nums中的元素的个数
		}
	}
	private int sum(int i){//计算nums[0,i]的和
		i++;//bit中的下标
		int sum=0;
		while(i>0){
			sum+=bit[i];
			i-=(i&-i);
		}
		return sum;
	}


}

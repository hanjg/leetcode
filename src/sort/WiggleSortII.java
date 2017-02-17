package sort;
import java.util.Arrays;

public class WiggleSortII {

    public void wiggleSort(int[] nums) {
    	int[] temp=Arrays.copyOf(nums, nums.length);
    	Arrays.sort(temp);
        int mid=(nums.length+1)/2;//前半部分的元素数量，保证前半部分数量等于后半部分，或者大1
        int first=mid-1,second=nums.length-1;
        for(int i=0;i<nums.length;i++){
        	nums[i]=(1&i)==0?temp[first--]:temp[second--];//(1&i)==0i为偶数
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

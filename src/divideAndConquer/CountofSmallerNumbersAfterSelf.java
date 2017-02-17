package divideAndConquer;
import java.util.*;
public class CountofSmallerNumbersAfterSelf {
	
	List<Integer> right;
    public List<Integer> countSmaller(int[] nums) {
        Integer[] count=new Integer[nums.length];//nums[i]右边比nums[i]小的数个数为count[i]
        right=new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
        	count[i]=findIndex(nums, nums[i]);//存储所有排好序的nums[i]右边的数
        	right.add(count[i], nums[i]);
        }
        return Arrays.asList(count);
    }
    
    private int findIndex(int nums[],int target){
    	//找到nums[i]在right中的下标，即为nums[i]右边比他小的数的个数
    	if (right.size()==0) {
			return 0;
		}
    	int low=0,high=right.size()-1;
    	if (right.get(0)>=target) {
			return 0;
		}
    	if (right.get(high)<target) {
			return high+1;
		}
    	while(low+1<high){//最终right[low]<target<=right[high]
    		int mid=(low+high)/2;
    		if (right.get(mid)<target) {
				low=mid+1;
			}
    		else {
				high=mid;
			}
    	}
    	if (right.get(low)>=target) {//如果此时的low和high的元素相等
			return low;
		}
    	return high;
    }
    
    int[] count;//nums[i]右边比nums[i]小的数个数为count[i]
    int[] address;//存储初始nums中元素的下标地址
	public List<Integer> countSmaller2(int[] nums) {
		count=new int[nums.length];
		address=new int[nums.length];
		for(int i=0;i<nums.length;i++){
			address[i]=i;
		}
		mergeSort(nums, 0, nums.length-1);
		List<Integer> result=new ArrayList<>();
		for(int i=0;i<count.length;i++){
			result.add(count[i]);
		}
		return result;
	}
	private void mergeSort(int[] nums,int begin,int end){
		if (begin>=end) {
			return;
		}
		int mid=(begin+end)/2;
		mergeSort(nums, begin, mid);
		mergeSort(nums, mid+1, end);
		merge(nums, begin, end);
	}
	
	private void merge(int[] nums,int begin,int end){
		//将address[end,mid]和[mid+1,end]对应的两组数据归并
		int[] newAddress=new int[end-begin+1];
		int mid=(begin+end)/2;
		int p1=begin,p2=mid+1,p3=0;//p3指向newAdddress的指针
		int rightcount=0;//记录比该左边的数小的右边的数的个数
		//System.out.println("p1="+p1+"p2="+p2+"p3="+p3+"  "+begin+" "+end);
		while(p1<=mid&&p2<=end){
			if (nums[address[p2]]<nums[address[p1]]) {
				rightcount++;
				newAddress[p3++]=address[p2++];
			}
			else {
				count[address[p1]]+=rightcount;
				newAddress[p3++]=address[p1++];
			}
		}
		//System.out.println("p1="+p1+"p2="+p2+"p3="+p3+"  "+begin+" "+end);
		while(p1<=mid){
			count[address[p1]]+=rightcount;
			newAddress[p3++]=address[p1++];
		}
		while(p2<=end){
			newAddress[p3++]=address[p2++];
		}
		for(int i=0;i<newAddress.length;i++){
			address[begin+i]=newAddress[i];
		}
	}

	public static void main(String[] args){
		CountofSmallerNumbersAfterSelf test=new CountofSmallerNumbersAfterSelf();
		int[] nums={5,2,6,1};
		System.out.println(test.countSmaller2(nums));
	}
	
}

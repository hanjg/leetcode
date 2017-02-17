package binarySearch;


public class MedianofTwoSortedArrays {
	int total;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {//二分查找
    	total=nums1.length+nums2.length;
    	if(total%2==0)
    		return (findInKth(nums1, nums2, 0, 0,total/2+1)+
    				findInKth(nums1, nums2, 0, 0,total/2))/2;
    	else
    		return findInKth(nums1, nums2, 0, 0, (total+1)/2);
    }
    private double findInKth(int[]nums1,int[]nums2,int begin1,int begin2,int k){
    	//在nums1,begin1开始和nums2,begin2开始归并的数组中寻找第k个数
    	if(nums1.length-begin1>nums2.length-begin2)
    		return findInKth(nums2, nums1, begin2, begin1, k);//保证nums1[begin,end)短
    	if(begin1==nums1.length)return nums2[begin2+k-1];
    	if(k==1)return Math.min(nums1[begin1], nums2[begin2]);
    		
    	int n1=Math.min(k/2, nums1.length-begin1),n2=k-n1;//nums1和2中取出n1,n2个数,共k个
    	if(nums1[begin1+n1-1]==nums2[begin2+n2-1])return nums1[begin1+n1-1];
    	else if(nums1[begin1+n1-1]<nums2[begin2+n2-1])//目标不在nums1[0,begin+n1)
    		return findInKth(nums1, nums2, begin1+n1, begin2, k-n1);
    	else
    		return findInKth(nums1, nums2, begin1, begin2+n2, k-n2);
    }
    
    
    int m,n;
	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {//归并
		m=nums1.length;n=nums2.length;total=m+n;
		if(total%2==0)
			return ((double)findInK(nums1, nums2, total/2)+findInK(nums1, nums2, total/2-1))/2;
		else
			return (double)findInK(nums1, nums2, total/2);
	}
	private int findInK(int[] nums1,int[] nums2,int index){//找到归并的数组中下标为index的数
		int i=0,j=0,k=0;
		while(k<index){
			if(i==m)j++;
			else if(j==n)i++;
			else if(nums1[i]<nums2[j]) i++;
			else j++;
			k++;
		}
		if(i==m)return nums2[j];
		if(j==n)return nums1[i];
		return Math.min(nums1[i], nums2[j]);
	}
	public static void main(String[] args) {
		//int[] nums1={},nums2={1};
		int[] nums1={2},nums2={1,3};
		System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
	}
}

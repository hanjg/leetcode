package divideAndConquer;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int i=m-1,j=n-1,k=m+n-1;//三个指针分别表示nums1,nums2和归并之后的末尾
    	while(i>=0&&j>=0){
    		if (nums1[i]<nums2[j]) {
				nums1[k--]=nums2[j--];
			}
    		else {
				nums1[k--]=nums1[i--];
			}
    	}
    	while(j>=0){
    		nums1[k--]=nums2[j--];
    	}
    }
    
	public void merge2(int[] nums1, int m, int[] nums2, int n) {//使用额外空间
	    int[] temp=new int[m+n];
	    int i=0,j=0,k=0;
	    while(i<m&&j<n){
	    	if (nums1[i]<nums2[j]) {
				temp[k++]=nums1[i++];
			}
	    	else {
				temp[k++]=nums2[j++];
			}
	    }
	    while(i<m) temp[k++]=nums1[i++];
	    while(j<n) temp[k++]=nums2[j++];
	    System.arraycopy(temp, 0, nums1, 0, m+n);
	}

	public static void main(String[] args) {
		MergeSortedArray teSortedArray=new MergeSortedArray();
		int[] nums1={0},nums2={1};
		teSortedArray.merge(nums1, 0, nums2, 1);
		for(int i=0;i<nums1.length;i++){
			System.out.println(nums1[i]+" ");
		}
	}

}

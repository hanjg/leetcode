package binarySearch;

public class HIndexII {
    public int hIndex(int[] citations) {
        int n=citations.length;
        if(n==0||citations[n-1]==0)return 0;
        int low=0,high=n-1;
        while(low<=high){
        	int mid=(low+high)/2;
        	if (citations[mid]<n-mid) {
				low=mid+1;
			}
        	else {
				high=mid-1;
			}
        }
        return n-low;
    }

}

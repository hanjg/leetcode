package stack;

public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res=new int[k];//res分别从nums1,nums2中取i,k-i个元素
        int top=Math.min(nums1.length, k);
        for(int i=Math.max(0, k-nums2.length);i<=top;i++){
        	int[] temp=merge(maxArray(nums1, i), maxArray(nums2, k-i),k);
        	if(greater(temp, 0, res, 0))res=temp;
        }
        return res;
    }
    private int[] maxArray(int[] num,int k){//在num中按照顺序取k个元素使得总数最大
    	int[]res=new int[k];
    	for(int i=0,j=0;i<num.length;i++){//i:res中的指针,j:栈顶num中的指针
    		while(j>0&&res[j-1]<num[i]&&j+num.length-i>k)j--;
    		if(j<k)res[j++]=num[i];
    	}
    	return res;
    }
    private int[] merge(int[] n1,int[] n2,int k){//将n1,n2归并，使得总数最大
    	int[] res=new int[k];
    	for(int i=0,j=0,r=0;r<k;r++){
    		res[r]=greater(n1, i, n2, j)?n1[i++]:n2[j++];
    	}
    	return res;
    }
    private boolean greater(int[] n1,int begin1,int[] n2,int begin2){
    	//比较n1从begin1开始和n2从begin2开始的大小
    	while(begin1<n1.length&&begin2<n2.length){
    		if(n1[begin1]<n2[begin2])return false;
    		else if(n1[begin1]>n2[begin2])return true;
    		begin1++;begin2++;
    	}
    	return begin2==n2.length;
    }
}

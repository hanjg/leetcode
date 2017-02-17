package binarySearch;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
    	int n=nums.length;if(n==0)return false;
        int[] tail=new int[2];//记录长度为1和2的序列最小的结尾
        tail[0]=nums[0];int len=1;
        for(int i=1;i<n;i++){
        	if(len==1){
        		if(nums[i]<=tail[0])tail[0]=nums[i];
        		else tail[len++]=nums[i];
        	}else {
				if(nums[i]<=tail[0]) tail[0]=nums[i];
				else if(nums[i]<=tail[1]) tail[1]=nums[i];
				else return true;
			}
        }
        return false;
    }
    public static void main(String[] args){
    	System.out.println(new IncreasingTripletSubsequence().increasingTriplet(new int[]{0,4,2,1,0,-1,-3}));
    }
}

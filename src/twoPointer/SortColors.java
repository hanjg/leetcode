package twoPointer;

public class SortColors {

    public void sortColors(int[] nums) {
    	int p0=0,p1=nums.length;//0的范围[0,p0),1的范围[p0,p1),2的范围[p1,length)
    	for(int cur=0;cur<nums.length;cur++){
    		while(cur>=p0&&cur<p1&&nums[cur]!=1){
    			if (nums[cur]==0) {
					int temp=nums[cur];nums[cur]=nums[p0];nums[p0]=temp;p0++;
				}
    			else if (nums[cur]==2) {
					p1--;int temp=nums[cur];nums[cur]=nums[p1];nums[p1]=temp;
				}
    		}
    	}
    }
    
    public static void main(String[] args){
    	SortColors sortColors=new SortColors();
    	int[] nums={1,2,0};
    	sortColors.sortColors(nums);
    }
}

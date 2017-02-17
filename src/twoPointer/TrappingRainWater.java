package twoPointer;

public class TrappingRainWater {
    public int trap(int[] height) {
    	if(height.length<=2)return 0;
    	int sum=0;
    	int left=0,right=height.length-1;
    	int leftmax=height[left++],rightmax=height[right--];//[0,left)最大值，(right,length)的最大值
    	while(left<=right){
    		if (leftmax<rightmax) {
				leftmax=Math.max(leftmax, height[left]);//[0,left]的最大值
				sum+=Math.max(0, Math.min(leftmax, rightmax)-height[left++]);
			}
    		else {
				rightmax=Math.max(rightmax, height[right]);
				sum+=Math.max(0, Math.min(leftmax, rightmax)-height[right--]);
			}
    	}
    	return sum;
    }

}

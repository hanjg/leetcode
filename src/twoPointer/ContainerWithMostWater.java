package twoPointer;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int max=0;
        while(left<right)
        	max=Math.max((right-left)*(height[left]<height[right]?height[left++]:height[right--]), max);
        return max;
    }

}

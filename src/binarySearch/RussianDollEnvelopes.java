package binarySearch;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int n=envelopes.length;
        if(n==0||n==1)return n;
        Arrays.sort(envelopes, 0, n, new Comparator<int[]>() {
        	public int compare(int[] p1,int[] p2){
        		if(p1[0]==p2[0])return p2[1]-p1[1];
        		else return p1[0]-p2[0];
        	}
		});//宽度小的排前面，相同则高度大的排前面
        //这样可以保证按照顺序遍历数组若得到的高度比前一个大，则可以包含前一个
        int[] height=new int[n];//height[i]:层数为i+1的最外面一层的最小高度，
        height[0]=envelopes[0][1]; int num=1;//最大层数
        for(int i=1;i<n;i++){
        	int begin=0,end=num-1;
        	while(begin<=end){
        		int mid=(begin+end)/2;
        		if(envelopes[i][1]==height[mid]){begin=mid;break;}
        		else if(envelopes[i][1]<height[mid])end=mid-1;
        		else begin=mid+1;
        	}
        	if(begin==num)height[num++]=envelopes[i][1];
        	else height[begin]=envelopes[i][1];
        }
        return num;
    }
	public static void main(String[]args){
		System.out.println(new RussianDollEnvelopes().maxEnvelopes(new int[][]
				{{5,4},{6,4},{6,7},{2,3}}));
	}
}

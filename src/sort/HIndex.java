package sort;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h=0;//总共有h篇文章满足citation>=h
        for(int i=citations.length-1;i>=0;i--){
        	if (citations[i]<h+1) {
        		break;
			}
        	h++;
        }
        return h;
    }

}

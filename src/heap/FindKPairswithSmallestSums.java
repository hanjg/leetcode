package heap;
import java.util.*;
public class FindKPairswithSmallestSums {
	class Pair{
		int ix;//对应的nums[1]中的下标
		int[] data;
		Pair(int ix,int l,int r){
			this.ix=ix;
			data=new int[]{l,r};
		}
	}
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    	List<int[]>res=new ArrayList<>();
    	if(nums1==null||nums1.length==0||nums2==null||nums2.length==0) return res;
    	
    	PriorityQueue<Pair> queue=new PriorityQueue<>(Math.min(k, nums2.length), 
    			new Comparator<Pair>() {
    		public int compare(Pair o1,Pair o2){
    			return (o1.data[1]+o1.data[0])-(o2.data[1]+o2.data[0]);
    		}
    	});//存放以nums2[0,k)结尾的pair，共k个
    	for(int i=0;i<k&&i<nums2.length;i++){
    		queue.add(new Pair(0,nums1[0], nums2[i]));	
    	}
    	
    	while(k>0&&!queue.isEmpty()){
    		Pair temp=queue.poll();
    		res.add(temp.data);
    		if(temp.ix+1<nums1.length) queue.add(new Pair(temp.ix+1, nums1[temp.ix+1], temp.data[1]));
    		k--;
    	}
    	return res;
    }

}

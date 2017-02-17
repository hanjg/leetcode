package hashTable;

import java.util.*;

public class TopKFrequentElements {
	class Frequence{
		int num;
		int frequence;
		
		Frequence(int num,int frequence){
			this.num=num;
			this.frequence=frequence;
		}
	}
	
    public List<Integer> topKFrequent(int[] nums, int k) {
    	List<Integer> list=new ArrayList<>();
    	PriorityQueue< Frequence> queue=new PriorityQueue<>(nums.length,
    			new Comparator<Frequence>() {

					@Override
					public int compare(Frequence o1, Frequence o2) {
						return o2.frequence-o1.frequence;
					}
		});//存储数据和频率并且按照频率排列的最大堆
    	
    	//统计每个数据的频率，并将数据和频率放入最大堆
    	Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
        	int begin=i;
        	while(i+1<nums.length&&nums[i+1]==nums[i]) i++;
        	queue.add(new Frequence(nums[begin], i+1-begin));
        }
        
        for(int i=0;i<k;i++){
        	list.add(queue.poll().num);
        }
        return list;
    }
    
    public List<Integer> topKFrequent2(int[] nums, int k) {
		List<Integer> list=new ArrayList<>();
		HashMap<Integer, Integer> map=new HashMap<>();//K=数据，V=频率，统计和存储数据频率
		for(int i=0;i<nums.length;i++){
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i])+1);
			}
			else {
				map.put(nums[i], 1);
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Integer>[] buckets=new List[nums.length+1];//buckets[i]存放频率为i的数据的表
		Iterator<Integer> iterator=map.keySet().iterator();
		while(iterator.hasNext()){
			int key=iterator.next();
			int frequence=map.get(key);
			if (buckets[frequence]==null) {
				buckets[frequence]=new ArrayList<Integer>();
			}

			buckets[frequence].add(key);
		}
		
		for(int i=buckets.length-1;i>0&&k>0;i--){
			if (buckets[i]!=null) {
				k-=buckets[i].size();
				list.addAll(buckets[i]);
			}
		}
	    return list;
	}

	public static void main(String[] args){
    	TopKFrequentElements test=new TopKFrequentElements();
    	int[] nums={1,1,1,2,2,3};
    	System.out.println(test.topKFrequent2(nums, 2));
    }
}

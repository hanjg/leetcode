package design;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class AllOne {
	private Map<String, Integer> map = new HashMap<>();
	private PriorityQueue<String> minheap;
	private PriorityQueue<String> maxheap;
	
    /** Initialize your data structure here. */
    public AllOne() {
    	minheap = new PriorityQueue<>(10, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return map.get(o1) - map.get(o2);
			}
		});
    	maxheap = new PriorityQueue<>(10, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return map.get(o2) - map.get(o1);
			}
		});
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (map.containsKey(key)) {
			map.put(key, map.get(key) + 1);
			minheap.remove(key);
			maxheap.remove(key);
			minheap.add(key);
			maxheap.add(key);
		} else {
			map.put(key, 1);
			minheap.add(key);
			maxheap.add(key);
		}
        
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (map.containsKey(key)) {
			if (map.get(key) == 1) {
				map.remove(key);
				minheap.remove(key);
				maxheap.remove(key);
			} else {
				map.put(key, map.get(key) - 1);
				minheap.remove(key);
				maxheap.remove(key);
				minheap.add(key);
				maxheap.add(key);
			}
		}
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return map.isEmpty() ? "" : maxheap.peek();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return map.isEmpty() ? "" : minheap.peek();
    }
}

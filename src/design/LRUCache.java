package design;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    LinkedHashMap<Integer , Integer> map;
    private final int Capacity;
    
    public LRUCache(int capacity) {
        Capacity=capacity;
        map=new LinkedHashMap<Integer,Integer>(capacity, 0.75f, true){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
				//当put进新的值方法返回true时，便移除该map中最老的键和值
                return map.size()>Capacity;
            }
        };
    }
    
    public int get(int key) {
        return map.get(key)==null?-1:map.get(key);
    }
    
    public void set(int key, int value) {
    	map.put(key, value);
    }

}

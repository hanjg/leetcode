package design;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * problems-146 https://leetcode-cn.com/problems/lru-cache/
 */
public class LRUCache {

    private LinkedHashMap<Integer, Integer> map;

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {

            private static final long serialVersionUID = 5260388896780778056L;

            /**
             * 当put之后执行该方法
             * @param eldest
             * @return 是否移除该map中最老的键和值
             */
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return map.size() > LRUCache.this.capacity;
            }
        };
    }

    public int get(int key) {
        return map.get(key) == null ? -1 : map.get(key);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

}

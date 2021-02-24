package design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * problems-460 https://leetcode-cn.com/problems/lfu-cache/
 */
public class LFUCache {

    private Map<Integer, Node> keyMap;

    private Map<Integer, LinkedList<Node>> freqMap;
    private int minFreq;

    private int capacity;


    public LFUCache(int capacity) {
        keyMap = new HashMap<>(capacity);
        freqMap = new HashMap<>(capacity);
        this.capacity = capacity;
        minFreq = 0;
    }

    public int get(int key) {
        Node node = keyMap.get(key);
        if (node == null) {
            return -1;
        }
        removeInFreqBucket(node);
        node.freq++;
        addToFreqBucket(node);
        if (freqMap.get(minFreq) == null) {
            minFreq = node.freq;
        }
        return node.value;
    }

    private void removeInFreqBucket(Node node) {
        freqMap.get(node.freq).remove(node);
        if (freqMap.get(node.freq).isEmpty()) {
            freqMap.remove(node.freq);
        }
    }

    private void addToFreqBucket(Node node) {
        LinkedList<Node> targetBucket = freqMap.computeIfAbsent(node.freq, k -> new LinkedList<>());
        targetBucket.offerFirst(node);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = keyMap.get(key);
        if (node == null) {
            //插入
            node = new Node();
            node.key = key;
            node.value = value;
            node.freq = 1;
            keyMap.put(key, node);
            addToFreqBucket(node);
            //淘汰
            if (keyMap.size() > capacity) {
                Node toDel = freqMap.get(minFreq).getLast();
                keyMap.remove(toDel.key);
                removeInFreqBucket(toDel);
            }
            //更新最小频率
            minFreq = 1;
        } else {
            node.value = value;
            removeInFreqBucket(node);
            node.freq++;
            addToFreqBucket(node);
            if (freqMap.get(minFreq) == null) {
                minFreq = node.freq;
            }
        }
    }

    private class Node {

        private int key;
        private int value;
        private int freq;
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(0);
        cache.put(0, 0);
        System.out.println(cache.get(0));
    }
}

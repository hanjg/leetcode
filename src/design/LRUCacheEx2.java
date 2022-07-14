package design;

import java.util.HashMap;
import java.util.Map;

/**
 * hashmap+双向链表实现
 * problems-146 https://leetcode-cn.com/problems/lru-cache/
 */
public class LRUCacheEx2 {

    private Map<Integer, Node> map;

    /**
     * 记录使用顺序，最近使用的节点在前。收尾均为虚拟节点
     */
    private Node head;
    private Node tail;

    private int capacity;

    public LRUCacheEx2(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        delQueueNode(node);
        toQueueHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node();
            node.key = key;
            node.value = value;
            map.put(key, node);
            toQueueHead(node);
            if (map.size() > capacity) {
                map.remove(tail.pre.key);
                delQueueNode(tail.pre);
            }
        } else {
            node.value = value;
            delQueueNode(node);
            toQueueHead(node);
        }

    }

    private void toQueueHead(Node node) {
        node.next = head.next;
        node.pre = head;
        node.next.pre = node;
        node.pre.next = node;
    }

    private void delQueueNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private class Node {

        private int key;
        private int value;
        private Node pre;
        private Node next;
    }
}

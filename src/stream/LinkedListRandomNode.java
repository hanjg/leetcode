package stream;

import java.util.Random;

/**
 * problems-382 https://leetcode-cn.com/problems/linked-list-random-node/
 */
public class LinkedListRandomNode {

    private ListNode head;
    private Random random;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        int res = -1;
        //流元素计数
        int total = 0;
        //最新的流数据概率为 1/已经遍历的数据量
        ListNode node = head;
        while (node != null) {
            if (random.nextInt(++total) == 0) {
                //随机到当前数据
                res = node.val;
            }
            node = node.next;
        }
        return res;
    }

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

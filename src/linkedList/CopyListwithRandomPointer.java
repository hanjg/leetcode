package linkedList;

import java.util.HashMap;

/**
 * problems-138 https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
public class CopyListwithRandomPointer {

    public Node copyRandomList(Node head) {
        //老节点->新节点
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 深复制链表
     */
    private Node copy(Node head) {
        Node oldPre = new Node(-1);
        oldPre.next = head;
        Node newPre = new Node(-1);
        Node newVir = newPre;

        while (oldPre.next != null) {
            newPre.next = new Node(oldPre.next.val);
            oldPre = oldPre.next;
            newPre = newPre.next;
        }
        return newVir.next;
    }

    public static void main(String[] args) {
        CopyListwithRandomPointer copyListwithRandomPointer = new CopyListwithRandomPointer();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
//        for (Node cur = head; cur != null; cur = cur.next) {
//            System.out.println(cur.val);
//        }

        Node newHead = copyListwithRandomPointer.copy(head);

        for (Node cur = newHead; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }

    public static class Node {

        private int val;

        private Node next, random;

        public Node(int x) {
            this.val = x;
        }
    }
}

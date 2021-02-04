package design;

/**
 * problems-1206 https://leetcode-cn.com/problems/design-skiplist/
 */
public class Skiplist {

    /**
     * redis为32层，题目中2w个数考虑最高层级16
     */
    private static final int MAX_LEVEL = 16;
    private static final double UP_PROBABILITY = 1 / 2d;

    private SkipListNode head;

    public Skiplist() {
        head = new SkipListNode();
        head.forwards = new SkipListNode[MAX_LEVEL];
    }

    public boolean search(int target) {
        SkipListNode pre = searchPre(target);
        return pre.forwards[0] != null && pre.forwards[0].obj == target;
    }

    /**
     * @return 小于target 的最大值
     */
    private SkipListNode searchPre(int target) {
        SkipListNode cur = head;
        for (int level = MAX_LEVEL; level > 0; level--) {
            while (cur.forwards[level - 1] != null && cur.forwards[level - 1].obj < target) {
                cur = cur.forwards[level - 1];
            }
        }
        return cur;
    }

    public void add(int num) {
        SkipListNode pre = searchPre(num);
        int newLevel = randomLevel();
        SkipListNode newNode = new SkipListNode();
        newNode.forwards = new SkipListNode[MAX_LEVEL];
        newNode.obj = num;
        for (int level = newLevel; level > 0; level--) {
            newNode.forwards[level - 1] = pre.forwards[level - 1];
            pre.forwards[level - 1] = newNode;
        }
    }

    private int randomLevel() {
        int level = 1;
        while (level < MAX_LEVEL && Math.random() < UP_PROBABILITY) {
            level++;
        }
        return level;
    }

    public boolean erase(int num) {
        SkipListNode pre = searchPre(num);
        if (pre.forwards[0] == null || pre.forwards[0].obj != num) {
            return false;
        }
        SkipListNode toDel = pre.forwards[0];
        for (int level = MAX_LEVEL; level > 0; level--) {
            if (pre.forwards[level - 1] != toDel) {
                continue;
            }
            pre.forwards[level - 1] = toDel.forwards[level - 1];
        }
        return true;
    }

    private class SkipListNode {

        private SkipListNode[] forwards;
        private int obj;
    }

    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        System.out.println(skiplist.search(0));
        skiplist.add(4);
        System.out.println(skiplist.search(1));
        System.out.println(skiplist.erase(0));
        System.out.println(skiplist.erase(1));
        System.out.println(skiplist.search(1));
    }
}


package binaryIndexedTree;

/**
 * problems-307 https://leetcode-cn.com/problems/range-sum-query-mutable/  线段树
 */
public class RangeSumQueryMutable2 {

    /**
     * tree[n,2n) 存nums[0,n);tree[i]的子节点为tree[2i],tree[2i+1]，值和下标范围为两个子节点和
     */
    private int[] tree;

    private int n;

    public RangeSumQueryMutable2(int[] nums) {
        n = nums.length;
        tree = new int[2 * n];
        for (int i = n; i < 2 * n; i++) {
            tree[i] = nums[i - n];
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    public void update(int i, int val) {
        int cur = i + n;
        tree[cur] = val;
        while (cur > 0) {
            cur /= 2;
            tree[cur] = tree[2 * cur] + tree[2 * cur + 1];
        }
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        int l = i + n;
        int r = j + n;
        while (l <= r) {
            //l为右节点(内侧) 2i+1
            if (l % 2 == 1) {
                sum += tree[l++];
            }
            //r为左节点(内侧) 2i
            if (r % 2 == 0) {
                sum += tree[r--];
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        RangeSumQueryMutable2 rangeSumQueryMutable2 = new RangeSumQueryMutable2(new int[]{1, 3, 5});
        System.out.println(rangeSumQueryMutable2.sumRange(0, 2));
        rangeSumQueryMutable2.update(1, 2);
        System.out.println(rangeSumQueryMutable2.sumRange(0, 2));
    }
}

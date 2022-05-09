package weekly;


import javafx.util.Pair;

/**
 * @author anxi
 * @version 2022/5/8 10:45
 */
public class Week2 {

    private int count;

    public int averageOfSubtree(TreeNode root) {
        Pair<Long, Integer> pair = mid(root);
        return count;
    }

    private Pair<Long, Integer> mid(TreeNode node) {
        if (node == null) {
            return new Pair<>((long) (0), 0);
        }
        Pair<Long, Integer> left = mid(node.left);
        Pair<Long, Integer> right = mid(node.right);
        long sum = left.getKey() + right.getKey() + node.val;
        int c = left.getValue() + right.getValue() + 1;
        if (sum / c == node.val) {
            count++;
        }
        return new Pair<>(sum, c);
    }
}

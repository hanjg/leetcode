import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] arr = line.split(" ");
        int n = Integer.parseInt(arr[0]);
        int rootVal = Integer.parseInt(arr[1]);
        Map<Integer, Node> nodeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            line = in.nextLine();
            arr = line.split(" ");
            int cur = Integer.parseInt(arr[0]);
            int left = Integer.parseInt(arr[1]);
            int right = Integer.parseInt(arr[1]);
            Node curNode = null;
            if (nodeMap.containsKey(cur)) {
                curNode = nodeMap.get(cur);
            } else {
                curNode = new Node(cur);
                nodeMap.put(cur, curNode);
            }
            if (left != 0) {
                curNode.left = new Node(left);
            }
            if (right != 0) {
                curNode.right = new Node(right);
            }
        }

        List<Integer> visited = new ArrayList<>();
        visit(nodeMap.get(rootVal), visited);
        int toVisit = Integer.parseInt(in.nextLine());

        boolean hasNext = false;
        for (int i = 0; i < visited.size(); i++) {
            if (visited.get(i) == toVisit && i != visited.size() - 1) {
                System.out.println(visited.get(i + 1));
                hasNext = true;
                break;
            }
        }
        if (!hasNext) {
            System.out.println(0);
        }

    }

    private static void visit(Node node, List<Integer> visited) {
        if (node == null) {
            return;
        }
        visit(node.left, visited);
        visited.add(node.val);
        visit(node.right, visited);
    }


    private static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int value) {
            this.val = value;
        }
    }
}
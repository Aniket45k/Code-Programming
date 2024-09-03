import java.util.*;

public class leftView {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> leftSideView(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        leftView(root, 0, result);
        return result;
    }

    private static void leftView(Node root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(root.data);
        }
        leftView(root.left, level + 1, res);
        leftView(root.right, level + 1, res);

    }

    public static void main(String[] args) {

        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         * \
         * 8
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(8);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> LV = leftSideView(root);
        System.out.print("Left View Traversal: ");
        for (int node : LV) {
            System.out.print(node + " ");
        }
        System.out.println();

    }
}

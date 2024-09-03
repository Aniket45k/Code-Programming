import java.util.*;

public class isDeadEndExist {
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

    public static boolean solve(Node root, int min, int max) {
        if (root == null) {
            return false;
        }
        if (min == max) {
            return true;
        }
        return solve(root.left, min, root.data - 1) || solve(root.right, root.data + 1, max);
    }

    public static boolean isDead(Node root) {
        return solve(root, 1, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        // Creating a sample binary search tree
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right.right = new Node(12);

        // Checking if a dead end exists in the binary search tree
        boolean isDeadEnd = isDeadEndExist.isDead(root);

        // Printing the result
        if (isDeadEnd) {
            System.out.println("Dead end exists in the binary search tree.");
        } else {
            System.out.println("No dead end exists in the binary search tree.");
        }
    }
}

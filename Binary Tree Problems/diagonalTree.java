import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class diagonalTree {
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

    public static ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        if (root == null) {
            return ans;
        }

        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            while (temp != null) {
                if (temp.left != null) {
                    q.add(temp.left);
                }
                ans.add(temp.data);
                temp = temp.right;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        ArrayList<Integer> diagonalElements = diagonal(root);
        System.out.println("Diagonal elements of the tree:");
        for (Integer element : diagonalElements) {
            System.out.print(element + " ");
        }
    }
}

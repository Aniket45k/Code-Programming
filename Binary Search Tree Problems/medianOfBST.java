import java.util.*;

public class medianOfBST {
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

    public static void countNodes(Node root, int[] count) {
        if (root == null)
            return;
        countNodes(root.left, count);
        count[0]++;
        countNodes(root.right, count);
    }

    public static void findKthNode(Node root, Node[] cur, Node[] prev, int[] count, int k, int[] found) {
        if (root == null)
            return;
        findKthNode(root.left, cur, prev, count, k, found);
        if (prev[0] == null) {
            prev[0] = root;
            count[0]++;
        } else if (count[0] == k) {
            count[0]++;
            cur[0] = root;
            found[0] = 1;
            return;
        } else if (found[0] == 0) {
            count[0]++;
            prev[0] = root;
        }
        findKthNode(root.right, cur, prev, count, k, found);
    }

    public static float findMedian(Node root) {
        int[] count = { 0 };
        countNodes(root, count);
        Node[] cur = { null };
        Node[] prev = { null };
        int[] c = { 1 };
        int x = (count[0] / 2) + 1;
        int[] found = { 0 };
        findKthNode(root, cur, prev, c, x, found);
        if ((count[0] & 1) == 1) {
            return (float) cur[0].data;
        } else {
            return (cur[0].data + prev[0].data) / 2.0f;
        }
    }

    public static void main(String[] args) {
        // Create a binary search tree
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(8);

        // Calculate and print the median of the binary search tree
        float median = medianOfBST.findMedian(root);
        System.out.println("Median: " + median); // Output: 5.0
    }
}
